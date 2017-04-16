var tools = require('./tools.js');
var cli = require('pixl-cli');


var makeReport = function(projectFile) {
   var project = tools.getModel(projectFile);
   var classes = tools.collectElements(project, "_type", "UMLClass")
   var interfaces = tools.collectElements(project, "_type", "UMLInterface") ;
   var classesAndInterfaces = classes.concat(interfaces);

   //get statistics
   var sumTotal = Object.keys(classesAndInterfaces).length;//total number of classes and interfaces
   var statistics = {};//statistics record the data we need
   for(var i in classesAndInterfaces) {//initlaze statistics
     statistics[classesAndInterfaces[i]._id] = {
       "name":classesAndInterfaces[i].name,
       "providers":[],
       "clients":[],
       "stability":null,
       "responsibility":null,
       "deviance":null
     };
   }
   for(var i in classesAndInterfaces) {//scan every class and interface to update statistics
     var rels = tools.collectElements(classesAndInterfaces[i], "_type", "UMLInterfaceRealization");
     var gens = tools.collectElements(classesAndInterfaces[i], "_type", "UMLGeneralization");
	   var asoctns = tools.collectElements(classesAndInterfaces[i], "_type", "UMLAssociation");
     var paras = tools.collectElements(classesAndInterfaces[i], "_type", "UMLParameter");


    for(var k in rels){//consider realization
      statistics[rels[k].target.$ref].clients.push(rels[k].source.$ref);
      statistics[rels[k].source.$ref].providers.push(rels[k].target.$ref);
    }
	   for(var k in gens) {//consider generalization
       statistics[gens[k].target.$ref].clients.push(gens[k].source.$ref);
       statistics[gens[k].source.$ref].providers.push(gens[k].target.$ref);
	   }
     for(var k in asoctns) {//consider association
		  if(asoctns[k].end2.navigable === true){
        statistics[asoctns[k].end1.reference.$ref].providers.push(asoctns[k].end2.reference.$ref);
        statistics[asoctns[k].end2.reference.$ref].clients.push(asoctns[k].end1.reference.$ref);
      }
      if(asoctns[k].end1.navigable === true){
        statistics[asoctns[k].end2.reference.$ref].providers.push(asoctns[k].end1.reference.$ref);
        statistics[asoctns[k].end1.reference.$ref].clients.push(asoctns[k].end2.reference.$ref);
      }
    }
     for(var k in paras){//consider parameters in operations
       var paraType = paras[k].type.$ref;
       if(paraType != undefined && statistics[paraType] != null){
         statistics[paraType].clients.push(classesAndInterfaces[i]._id);
         statistics[classesAndInterfaces[i]._id].providers.push(paraType);
       }
     }
   }


   statistics = removeDuplicates(statistics);//remove duplicates


   for(var key in statistics){//calculate stability, responsibility and deviance
     statistics[key].stability = 1 - (Object.keys(statistics[key].providers).length) / sumTotal;
     statistics[key].responsibility = (Object.keys(statistics[key].clients).length) / sumTotal;
     statistics[key].deviance = Math.abs(statistics[key].stability - statistics[key].responsibility);
   }

   //log results
   var rows = [
    	[ "ClassName", "stability", "responsibility", "deviance" ]
    ];
   for(var key in statistics){
    var row = [statistics[key].name, statistics[key].stability, statistics[key].responsibility,statistics[key].deviance];
    rows.push(row);
   }
   cli.print( cli.table(rows) + "\n" );

};




var removeDuplicates = function(statistics){
  for(var k in statistics){
    var s = statistics[k];
    if(s.clients != null){
      s.clients = s.clients.filter(function(item, pos) {
        return s.clients.indexOf(item) == pos;
      });
    }
    if(s.providers != null){
      s.providers = s.providers.filter(function(item, pos) {
        return s.providers.indexOf(item) == pos;
      });
    }

  }
  return statistics;
}



var main = function() {
   var readline = require('readline');
   var rl = readline.createInterface({
      input: process.stdin,
      output: process.stdout
   });

   rl.question("Enter file name: ", function(answer) {
      makeReport(answer);
      rl.close();
    });
};


main();

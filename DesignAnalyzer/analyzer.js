
var tools = require('./tools.js');
var cli = require('pixl-cli');
var makeReport = function(projectFile) {
   var project = tools.getModel(projectFile);
   var classes = tools.collectElements(project, "_type", "UMLClass");
   //count total, providers, and clients
   var total = Object.keys(classes).length;
   var statistics = {};
   for(var i in classes) {
     statistics[classes[i]._id] = {"name":classes[i].name, "providers":[], "clients":[], "stability":null, "responsibility":null, "deviance":null};
   }
   for(var i in classes) {
	   var asoctns = tools.collectElements(classes[i], "_type", "UMLAssociation");
     var gens = tools.collectElements(classes[i], "_type", "UMLGeneralization");
     for(var k in asoctns) {
		  if(asoctns[k].end2.navigable === true){
        statistics[asoctns[k].end1.reference.$ref].providers.push(asoctns[k].end2.reference.$ref);
        statistics[asoctns[k].end2.reference.$ref].clients.push(asoctns[k].end1.reference.$ref);
      }
      if(asoctns[k].end1.navigable === true){
        statistics[asoctns[k].end2.reference.$ref].providers.push(asoctns[k].end1.reference.$ref);
        statistics[asoctns[k].end1.reference.$ref].clients.push(asoctns[k].end2.reference.$ref);
      }
    }
	   for(var k in gens) {
       statistics[gens[k].target.$ref].clients.push(gens[k].source.$ref);
       statistics[gens[k].source.$ref].providers.push(gens[k].target.$ref);
	   }
   }
   //calculate stability, responsibility and deviance
   for(var key in statistics){
     statistics[key].stability = 1 - (Object.keys(statistics[key].providers).length) / total;
     statistics[key].responsibility = (Object.keys(statistics[key].clients).length) / total;
     statistics[key].deviance = Math.abs(statistics[key].stability - statistics[key].responsibility);
   }
   //log results
   var rows = [
    	[ "ClassName", "stability", "responsibility", "deviance" ]
    ];
   for(var key in statistics){
    //  console.log("id: " + key);
    //  console.log("  name: " + statistics[key].name);
    //  console.log("  providers: " + statistics[key].providers);
    //  console.log("  clients: " + statistics[key].clients);
    //  console.log("  stability: " + statistics[key].stability);
    //  console.log("  responsibility: " + statistics[key].responsibility);
    //  console.log("  deviance: " + statistics[key].deviance);
    var row = [statistics[key].name, statistics[key].stability, statistics[key].responsibility,statistics[key].deviance];
    rows.push(row);
   }
   cli.print( cli.table(rows) + "\n" );

  //  /*log description*/
  //  console.log("================");
  //  console.log("Description:");
  //  for(var i in classes) {
	//    console.log("id:" + classes[i]._id);
  //    console.log("    name:" + classes[i].name);
	//    var asoctns = tools.collectElements(classes[i], "_type", "UMLAssociation");
	//    console.log("    UMLAssociations:");
	//    for(var k in asoctns) {
	// 	  console.log("      end1: " + asoctns[k].end1.reference.$ref + "  navigable: " + asoctns[k].end1.navigable);
  //     console.log("      end2: " + asoctns[k].end2.reference.$ref + "  navigable: " + asoctns[k].end2.navigable);
	//    }
  //    var gens = tools.collectElements(classes[i], "_type", "UMLGeneralization");
  //    console.log("    UMLGeneralizations:");
	//    for(var k in gens) {
	// 	  console.log("      target: " + gens[k].target.$ref);
  //     console.log("      source: " + gens[k].source.$ref);
	//    }
  //  }


};

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

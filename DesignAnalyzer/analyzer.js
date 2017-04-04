
var makeReport = function(projectFile) {
   var tools = require('./tools.js');
   var project = tools.getModel(projectFile);
   var classes = tools.collectElements(project, "_type", "UMLClass");
   var statistics = {};
   for(var i in classes) {
     statistics[classes[i]._id] = {"name":classes[i].name, "providers":[], "clients":[]};
     console.log(classes[i]._id);
     console.log(statistics[classes[i]._id]);
   }
   //log calculation
   console.log("=======================================================");
   console.log("stability, responsibility, and deviance of every class: ");
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
   console.log(statistics);
   for(var id in statistics){
     console.log("id: " + id);
     console.log("  name: " + statistics.id);
     console.log("  providers: " + statistics.id.providers);
     console.log("  clients: " + statistics.id.clients);
   }
   //log description
   console.log("================");
   console.log("project classes:");
   for(var i in classes) {
	   console.log("  " + classes[i].name);
     console.log("    id:" + classes[i]._id);
	   var asoctns = tools.collectElements(classes[i], "_type", "UMLAssociation");
	   console.log("    UMLAssociations:");
	   for(var k in asoctns) {
		  console.log("      end1: " + asoctns[k].end1.reference.$ref + "  navigable: " + asoctns[k].end1.navigable);
      console.log("      end2: " + asoctns[k].end2.reference.$ref + "  navigable: " + asoctns[k].end2.navigable);
	   }
     var gens = tools.collectElements(classes[i], "_type", "UMLGeneralization");
     console.log("    UMLGeneralizations:");
	   for(var k in gens) {
		  console.log("      target: " + gens[k].target.$ref);
      console.log("      source: " + gens[k].source.$ref);
	   }
   }


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

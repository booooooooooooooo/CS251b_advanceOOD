
var makeReport = function(projectFile) {
   var tools = require('./tools.js');
   var project = tools.getModel(projectFile);
   var classes = tools.collectElements(project, "_type", "UMLClass");
   //count total, providers, and clients
   var total = Object.keys(classes).length;
   var statistics = {};
   for(var i in classes) {
     statistics[classes[i]._id] = {"name":classes[i].name, "providers":[], "clients":[], "instability":null, "responsibility":null, "deviance":null};
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
   //calculate instability, responsibility and deviance
   for(var key in statistics){
     statistics[key].instability = (Object.keys(statistics[key].providers).length) / total;
     statistics[key].responsibility = (Object.keys(statistics[key].clients).length) / total;
     statistics[key].deviance = Math.abs(1 - statistics[key].instability - statistics[key].responsibility);
   }
   //log results
   console.log("=======================================================");
   console.log("instability, responsibility, and deviance of every class: ");
   for(var key in statistics){
     console.log("id: " + key);
     console.log("  name: " + statistics[key].name);
     console.log("  providers: " + statistics[key].providers);
     console.log("  clients: " + statistics[key].clients);
     console.log("  instability: " + statistics[key].instability);
     console.log("  responsibility: " + statistics[key].responsibility);
     console.log("  deviance: " + statistics[key].deviance);
   }
   //log description
   console.log("================");
   console.log("Description:");
   for(var i in classes) {
	   console.log("id:" + classes[i]._id);
     console.log("    name:" + classes[i].name);
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

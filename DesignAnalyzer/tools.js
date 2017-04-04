/*
 * tools.js exports nodejs functions for
 * traversing nested JSON objects and filtering
 * out useful sub-elements.
 */

/*
 * uses the file system module(fs) to read
 * a file, then uses the JSON parser to
 * parse the file into a JSON object.
 */
exports.getModel = function (fname) {
   var fs = require('fs');
   return JSON.parse(fs.readFileSync(fname, 'utf8'));
}

/*
 * recursively traverses a JSON object (or array), applying a
 * specified callback function to each element it encounters.
 * the traversal stops if the callback returns true or the entire
 * object is traversed.
 */
exports.visit = function(obj, callBack) {
	var result = callBack(obj);
	if (!result && obj != null && (typeof obj == "object" || typeof obj == "array")) {
		for(var i in obj) {
		   result = exports.visit(obj[i], callBack);
		   if (result) break;
		}
	}
	return result;
}

/*
 * Given Aan object, key, and value, this function traverses
 * the object and collects all sub-objects x with x.key == val
 * into an array.
 */
exports.collectElements = function(obj, key, val) {
	var result = [];
	var filter = function(elem) {
		if (elem != null && typeof elem[key] != null && elem[key] == val) {
			result.push(elem);
		}
	}
	exports.visit(obj, filter);
	return result;
}

/*
 * This is a useful StarUML-specific function that searches a model looking
 * for the type of a thing. This works even if the thing is a reference to
 * some other object in the model.
 */
exports.getType = function(model, thing) {
	var tp = "void";
	if (thing != null && typeof thing == "object" && typeof thing.type != "undefined") {
		tp = thing.type;
		if (typeof tp == "object" && typeof tp.$ref != "undefined") {
			tp = exports.getReference(model, tp.$ref).name;
		}
	}
	return tp;
}

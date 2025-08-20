//Program to demonstrate the type conversions in java script
var x=undefined;
console.log(Boolean(x)); //Falsy Value
var v=null;
console.log(Boolean(v)); //Falsy value
var v=0;
console.log(Boolean(v));
console.log(Boolean("")); //Returns False
console.log(Boolean(1));//Returns True
console.log(Boolean(12));
console.log(typeof((v.toString()))); //Converts to String
console.log(Boolean(v.toString())); //Returns True
console.log((String(false))); 
console.log(Boolean(null)); //Falsy Value
let str="demonstration"
console.log(typeof(Number(str)));//Returns Number
console.log((Number(str)));//Returns NaN
console.log(Boolean(Number(str))); //Returns false because Nan is a falsy value
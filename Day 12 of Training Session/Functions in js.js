//Program to demonstrate the usage of functions in java script
function details(var1,var2,var3="Concatenation")
{
    console.log(var1);
    console.log(var2);
    console.log(var3.toLowerCase());
}
console.log(details("Delhi",'Pune'));

function f2(var1,var2,var3="Chennai")
{
    console.log(var1);
    console.log(var2);
    console.log(var3="Hyderabad"); //only Hyderabad will be printed as it can be overriden
}
console.log(f2("Bangalore",'SanFrancisco','New York'));
city='Kolkata'  //global variable
let var1='ottawa'
var var2='Orlando'
function cities(var1,var2,city)
{
  console.log(var1='Dallas'); 
  console.log(var2='LasVegas');
  console.log(city); //It overrides Kolkata and prints Venice
}
cities('London','Paris','Venice');
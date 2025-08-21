//Program to demonstrate the ternary chaining in java script
let marks=100;
let result=marks<35?"Fail":marks>35&&marks<=50?"Grade E":marks>50&&marks<=60?"Grade D":marks>60&&marks<=70?"Grade C":marks>70&&marks<=80?"Grade B":marks>80&&marks<=90?"Grade A":marks>90&&marks<=100?"Grade A+":"Please enter your Marks Properly";
console.log(result);
function displayresult(mark1)
{
    let marks=mark1;
    let result=marks<35?"Fail":marks>35 && marks<=50?"Grade E":marks>50 && marks<=60?"Grade D":marks>60 && marks<=70?"Grade C":marks>70 && marks<=80?"Grade B":marks>80 && marks<=90?"Grade A":marks>90 && marks<=100?"Grade A+":"Please enter your Marks Properly";
    return result;
}
console.log(displayresult(58));
var d1=1334.1    //var can be redeclared and reassigned using the same variable
console.log(d1);  //let can be reassigned but can not be redeclared
var d1="mystring"   
console.log(d1)
//ternary chaining using arrow function
let v=(volts)=>volts<=300?"Free":volts>=400 && volts<500?"Pay 700Rs":volts>=500 && volts<600?"Pay 800Rs":volts>=600 && volts<700?"Pay 900Rs":volts>=700 && volts<800?"Pay 1000rs":volts>=800 && volts<900?"Pay 1200Rs":"Pay 1500Rs"
console.log(v(694));

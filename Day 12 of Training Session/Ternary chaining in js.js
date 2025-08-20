//Program to demonstrate the ternary chaining in java script
let marks=100;
let result=marks<35?"Fail":marks>35&&marks<=50?"Grade E":marks>50&&marks<=60?"Grade D":marks>60&&marks<=70?"Grade C":marks>70&&marks<=80?"Grade B":marks>80&&marks<=90?"Grade A":marks>90&&marks<=100?"Grade A+":"Please enter your Marks Properly";
console.log(result);
function displayresult(mark1)
{
    let marks=mark1;
    let result=marks<35?"Fail":marks>35&&marks<=50?"Grade E":marks>50&&marks<=60?"Grade D":marks>60&&marks<=70?"Grade C":marks>70&&marks<=80?"Grade B":marks>80&&marks<=90?"Grade A":marks>90&&marks<=100?"Grade A+":"Please enter your Marks Properly";
    return result;
}
console.log(displayresult(58));
var d1=1334.1
console.log(d1);
var d1="mystring"
console.log(d1)

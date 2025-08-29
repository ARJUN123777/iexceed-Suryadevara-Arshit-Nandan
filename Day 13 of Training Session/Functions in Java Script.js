//Program to demonstrate the more use of fucntions in js
'use strict';
let age=20;
if(age>18)
   {
    var v=function vote()   
    {
    console.log("You are eligible to vote");
   };
}
   else
   {
      var v=function vote()
      {
        console.log("Not Eligible to vote");
      };
   }
v();

let marks=36 
if(marks>35)
   {
    var eligible=function()   
    {
    console.log("Poor Students")
   };
   }
   else if(marks>35 && marks<90)
   {
      var eligible=function()
      {
        console.log("Average Students")
      };
   }
   else
    {
       var eligible=function()
       {
        console.log("Outstanding Students")
       }
   };
eligible();
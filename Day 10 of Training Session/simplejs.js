//javascript program to demonstrate the use of functions and their operations
function add(x,y)
{
  console.log(x+x);
  sub(x,y);
  function sub(x,x)
  {
    console.log(x-y);
    console.log(x+y);
  }
  sub(x,x);
  add1(x,y);
  function add1(x,x)
  {
       console.log("The value of x: ",x);
       console.log(x+y);
  }
}
add(10,20);
function iteration()
{
  for(let i=0;i<7;i++)
  {
    console.log(i);
    console.log(delete i); //output will be false
  }
  //console.log(i);//It shows an error 
}
iteration();
'use strict';
var val="true";
function istrue()
{
  if(val)
  {
    console.log("The answer is true");
  }
  else
  {
    console.log("The answer is false");
  }
}
istrue();
'use strict';
 function deleteme()
{
    var x=1000;
    console.log(delete x);
    console.log(x);
}
deleteme();
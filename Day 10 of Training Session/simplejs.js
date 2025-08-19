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
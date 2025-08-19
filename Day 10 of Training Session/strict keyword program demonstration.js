//java script program to demonstrate the use of strict keyword
function withoutstrict(x,x)   //This will not cause an error
{
    console.log(x+x);
}

function withstrict(x)
{
    'use strict';
     return x+x;
}
withoutstrict(10,20);
"use strict";        
console.log(withstrict(10));
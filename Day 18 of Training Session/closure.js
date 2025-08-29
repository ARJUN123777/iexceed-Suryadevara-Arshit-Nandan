//javascript program to demonstrate the closure in functions
function outerfunc()
{
    let a=0
    return function()
    {
        a+=3
        return a
    }
}
const v1=outerfunc()
v2=outerfunc()
console.log(v1())
console.log(v1())
console.log(v2())

function outer1()
{
    let c=72
    inner1=function()
    {
        c++;
        return c;
    }
    return inner1()
}

console.log(outer1())
console.log(outer1())
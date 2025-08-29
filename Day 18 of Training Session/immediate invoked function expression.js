//Program to demonstrate the inmmediately invoked function expression
(
function displaydetails(ename,age,address)
{
    console.log(`Name: ${ename}`)
    console.log(`Age: ${age}`)
    console.log(`Address: ${address}`)
})('Paresh',23,'Bandra,Mumbai');
(
 function(...args)
 {
    console.log(`The Minimum number from the arguments is ${(Math.min(...args))}`)
    console.log(`The Maximum number from the arguments is ${(Math.max(...args))}`)
 }
)(34,62,47,283,4834,-283,-3854,747.28,138.1);
//using arrow function
(
(obj)=>{
 for(let [key,value] of  Object.entries(obj))
 {
   console.log(key,'-',value)
 }
}
)({id:786,ename:'Hritesh',dept:'Cyber security',address:'pune'})
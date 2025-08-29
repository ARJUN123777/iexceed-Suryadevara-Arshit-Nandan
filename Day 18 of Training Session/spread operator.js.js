//Program to demonstrate the spread operator in javascript
const st1={name:"Deva",gender:'M',marks:{maths:89,social:90,science:91,english:71}}
console.log(`${st1.name} got More marks in ${Math.min(...Object.values(st1.marks))}`) 
console.log(`${st1.name} got Less Marks in ${Math.max(...Object.values(st1.marks))}`)
let sum=0
for(const values of Object.values(st1.marks))
{
     sum+=values
}
let avg=sum/(Object.values(st1.marks).length)
console.log(`${st1.name} has an average of ${avg}`)

const lib={politics:51,Geography:61,Psychology:21,Mathematics:62,Physics:38,Computer_Applications:42}
let max=Math.max(...Object.values(lib))  //Finding the maximum number of books
let ma=Object.keys(lib).find(key=>lib[key]==max) //Finding which domain has more number of books
console.log(`${ma} has more number of books`);
let min=Math.min(...Object.values(lib)) //Finding the minimum number of books
let mi=Object.keys(lib).find(key=>lib[key]==min) //Finding which domain has less number of books
console.log(`${mi} has less number of books`);
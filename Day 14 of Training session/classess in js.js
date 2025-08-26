//Program to demonstrate classes in java script
class calculator
{
    constructor(x,y)
    {
         this.x=x
         this.y=y
    }
    addition=function()
    {
        return this.x+this.y;
    }
    subtraction=function()
    {
         return this.x-this.y
    } 
    multiplication=function()
    {
        return this.x*this.y
    }
    division=function()
    {
        return this.x/this.y;
    }
}
let result=new calculator(231123,92312)
console.log(`The sum of the Numbers is ${result.addition()}`)
console.log(`The Difference between the  numbers is ${result.subtraction()}`)
console.log(`The product of two numbers is ${result.multiplication()}`)
console.log((`The Remainder of two numners is ${result.division()}`))

result=new calculator(23,29)
console.log(`The sum of the Numbers is ${result.addition()}`)
console.log(`The Difference between the  numbers is ${result.subtraction()}`)
console.log(`The product of two numbers is ${result.multiplication()}`)
console.log((`The Remainder of two numners is ${result.division()}`))
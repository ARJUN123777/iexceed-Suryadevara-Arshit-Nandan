//Program to demonstrate the objects in javascript
const std1={id:345,name:'Devansh',class:9,sec:'B',marks:{Maths:87,Social:79,Science:81,English:91}}
Object.defineProperty(std1,"Average",{
    get:function()
    {
        let sum=0;
        let avg;
        for(const value of Object.values(this.marks))
        {
            sum=sum+value 
        }
        avg=sum/Object.values(this.marks).length
      return `The Average of ${this.name} is ${avg}`
    }
})
Object.defineProperties(std1,{
    "Min":
    {
    get()
    {    //Math.min does not take array of values directly as an argument
        let min= Math.min(...Object.values(this.marks))  //using the spread operator to create arguments for the values
        let sub=Object.keys(this.marks).find(key=>this.marks[key]==min)
        return `${this.name} got Minimum marks in ${sub} Subject`
    }
    },
    "Max":
    {
    get()
    {    //Math.max does not take array of values directly as an argument
         let max= Math.max(...Object.values(std1.marks))  //using the spread operator to create arguments for the values
        let sub=Object.keys(std1.marks).find(key=>std1.marks[key]==max)
        return `${this.name} got Maximum marks in ${sub} Subject`
    }
    }}
)
console.log(std1.Average)
console.log(std1.Min)
console.log(std1.Max)
console.log(Object.getOwnPropertyNames(std1))
console.log(Object.getPrototypeOf(std1))
for(let [key,value] of Object.entries(std1))
{
    console.log(key,'-',value)
}
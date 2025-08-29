//Program to bind the propeties of one object to another
let cal=
{
    avg:function()
    {
        let sum=0;
        let avg;
        for(const value of Object.values(this.marks))
        {
            sum=sum+value 
        }
        avg=sum/Object.values(this.marks).length
        console.log(`The Average of ${this.name} is ${avg}`)
    },
    min:function()
    {    //Math.min does not take array of values directly as an argument
        let min= Math.min(...Object.values(this.marks))  //using the spread operator to create arguments for the values
        let sub=Object.keys(this.marks).find(key=>this.marks[key]==min)
        console.log(`${this.name} got Minimum marks in ${sub} Subject`)
    },
    max:function()
    {    //Math.max does not take array of values directly as an argument
         let max= Math.max(...Object.values(this.marks))  //using the spread operator to create arguments for the values
        let sub=Object.keys(this.marks).find(key=>this.marks[key]==max)
        console.log(`${this.name} got Maximum marks in ${sub} Subject`)
    }
}
const std1={id:345,name:'Devansh',class:9,sec:'B',marks:{Maths:87,Social:79,Science:81,English:91}}
const std2={id:352,name:'Priyanka',class:9,sec:'C',marks:{Maths:82,Social:76,Science:78,English:67}}
cal.avg.bind(std1)() //bind function is used to create a new function with this. value
cal.min.bind(std1)()
cal.max.bind(std1)()
cal.avg.bind(std2)()
cal.min.bind(std2)()
cal.max.bind(std2)()

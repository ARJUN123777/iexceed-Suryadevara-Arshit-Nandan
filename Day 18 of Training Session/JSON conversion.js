//Program to convert the objects into jason data format
const emp1=
{
 id:'KTL7181',
 name:'Deepika',
 age:'29',
 gender:'F',
 projects_worked:
 {
    value:
    {
        LTIProject:{projectid:'LT6271',role:'Backend Developer',performance:"Good"},
        RANDSTADProject:{projectid:'RD4529',role:'JAVASCRIPT ENGINEER',performance:"Excellent"}
    }
 },
 salaryreceived:true,
 appraisal:undefined, //undefined will not be stored in json format
 address:'BANDRA WEST,MUMBAI'
}
jsondata=JSON.stringify(emp1);
console.log(jsondata)
console.log(typeof(jsondata))
const emp=JSON.parse(jsondata)//used to convert the json data back to javascript object
console.log(emp)
console.log(typeof(emp))
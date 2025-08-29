//Program to demonstrate the functions in javascript
const prompt=require("prompt-sync")()
function empdetails()
{
   return `Employee Id:CL4632
    Name:Mathews
    Age: 27
    Gender:M
    City:Pune
    Country:India`
}
function ofcdetails()
{
    return  `Employee id:CL4632
    Employee Dept:CLOUD
    Employee salary:1000000
    Employee Performance:Good`
}
let name=prompt('Your Name: ')
console.log("What do u want to display?")
console.log("1.Employee Details")
console.log("2.Office Details")
const d=prompt("\nEnter your choice: ")
let result=(d=="1")?empdetails():(d=="2")?ofcdetails():"Please select the valid option"
console.log(result)

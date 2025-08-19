//Program to demonstrate the use of objects in java script
let employee={empid:1762,name:'Thomas Gonzalez',branch:'IT',Height:6.1,Age:39,Address:'Delhi',Salary_Received:true,Insurance_Paid:undefined};
console.log(typeof(employee)); //Returns the data type of employee 
console.log(typeof(employee.branch));//Returns the data type of branch in employee
console.log(typeof(employee.empid));//Returns the data type of the empid in employee
console.log(typeof employee.Salary_Received); //Returns the data type of Salary_Received in employee 
console.log(typeof employee.Insurance_Paid);  //Returns the data type of Insurance_Paid in employee
console.log(typeof(employee.Height));//Returns the data type of Height in employee
let v=200;
let val="Master Piece"
console.log(`The employee name is ${employee.name}`);
console.log(`The Employee Id is ${employee.empid}`);
console.log(`The painting is such a ${val} that more than ${v+" Visitors"} had come to see the painting`);
//Program to demonstrate the use of arrow functions.
let stringresult=(str)=>str.trim().toUpperCase();
console.log(stringresult(" towerhouse "));
let operations=(a,b,c,d)=>a+b+c+d;
console.log(operations(1,2,3,4));
const mail=(x)=>x+"@"+"gmail.com";
console.log(mail("devansh"));
let empdetails=(id,empname,depart,gender,salary)=>"id:"+id+"\n"+"name:"+empname+"\n"+"Department:"+depart+"\n"+"Gender:"+gender+"\n"+"Salary:"+salary;
console.log(empdetails(162,"Vivek","Cyber Security",'M',1600000));
var stdetails=(id,stname,cl,sec,feesPaid)=>arguments();
console.log(stdetails(159,'Arjun',10,'M',50000));

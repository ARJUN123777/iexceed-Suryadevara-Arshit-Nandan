//Program to demonstrate the use of arrow functions.
let stringresult=(str)=>str.trim().toUpperCase();
console.log(stringresult(" towerhouse "));
let operations=(a,b,c,d)=>a+b+c+d;
console.log(operations(1,2,3,4));
const mail=(x)=>x+"@"+"gmail.com";
console.log(mail("devansh"));
let empdetails=(id,empname,depart,gender,salary)=>"id:"+id+"\n"+"name:"+empname+"\n"+"Department:"+depart+"\n"+"Gender:"+gender+"\n"+"Salary:"+salary;
console.log(empdetails(162,"Vivek","Cyber Security",'M',1600000));
//var stdetails=(id,stname,cl,sec,feesPaid)=>arguments(id,stname,cl,sec,feesPaid);   //We can not use the arguments in the arrow function
//console.log(stdetails(159,'Arjun',10,'M',50000));

var details=(teachid,teachname,teachsubs,teachdept,teachsal)=>
{
    console.log("Teacher id: "+teachid);
    console.log("Tecaher Name: "+teachname);
    console.log("Teaching Subjects: "+teachsubs);
    console.log("Teacher Department: "+teachdept);
    console.log("Salary: "+teachsal);
}
console.log(details(372,'Sri Lakshmi',['Maths','Physics','Chemistry'],'Science',50000));


var bdetails=(bdno,bname,barea,bvalue,...args)=>
    {
     console.log("Building No: "+bdno);
     console.log("Building Name: "+bname);
     console.log("Building Area: "+barea);
     console.log("Cost of Building: "+bvalue);
     console.log(args.sort());
}
console.log(bdetails('TR122','Suavity Otium','Akshaynagar',2300000,'Bangalore urban','Bangalore','India','Asia',))

var x=(age)=>age>20 && age<=31?"Eligible to Government Exams":age>31 && age<50?"Apply for Ration Card":age>=50 && age<90?"Apply for Pension":"U are not eligible for government schemes"
console.log(x(29));




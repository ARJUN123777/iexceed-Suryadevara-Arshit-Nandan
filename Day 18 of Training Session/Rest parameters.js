//program to demonstrate rest parameters 
function displaydetails(name,age,aadhar,...args)
{
    console.log("Name: ",name);
    console.log("Age: ",age)
    console.log("AadharNo: ",aadhar)
    console.log(args.sort());
}
displaydetails("Tanmay",34,62738181229,'M','6.1','Andheri East,Mumbai,Pin-40049')

function f1(a,b,c,d,...args)
{
   let v=a+b
   v-=c*d
   for(let i in args)
   {
    v+=Number(args[i])
   }
   console.log(v)
}
f1(1,2,3,4,5,7,8,9);
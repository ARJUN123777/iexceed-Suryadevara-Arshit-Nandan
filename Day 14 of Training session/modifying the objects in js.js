//Program to create new object using the existing protoype object 
const account=
{   
    balance:0,
    deposit:function(amt)
    {
       this.balance+=amt
       console.log("Deposited Successfully")
       this.showbalance()
    },
    withdraw:function(amt)
    {
      this.balance-=amt;
      console.log("Collect Your Amount")
      this.showbalance()
    },
    showbalance:function()
    {
        console.log(`Your Balance is ${this.balance}`)
    },
    takeloan:function(p,t)
    {
        console.log(`The loan for ${p}Rs for a period of ${t}years and a rate of 5% is ${(p*5*(t))/(100)}`)
        console.log(`The loan for ${p}Rs for a period of ${t}years and a rate of 10% is ${(p*10*t)/(100)}`)
        console.log(`The loan for ${p}Rs for a period of ${t}years and a rate of 15% is ${(p*15*t)/(100)}`)
    }
}
const emp1=Object.create(account,
    {
    id:{value:"TR9231",writable:false,configurable:false,enumerable:true},  //Can not be deleted/redefined and modified
    name:{value:"Arjun",writable:false,configurable:false,enumerable:true},  //can not deleted but can be modified
    salary:{value:300000,writable:true,configurable:true,enumerable:false},  //can be deleted and but can not be modified
    address:{value:'Pune',writable:false,configurable:false,enumerable:true}, //can not be deleted and modified
    gender:{value:'M',writable:true,configurable:true,enumerable:false},  // can be deleted and modified but can not be enumerated
    //can not be deleted but can be modified and can not be enumerated
    bankaccounts:{value:['SBI','HDFC','Axis Bank','ICICI Bank'],writable:true,configurable:false,enumerable:false}
})
console.log(emp1.id);
console.log(Object.keys(emp1)) //bank accounts,salary  and gender are hidden 
for( let i in emp1.bankaccounts)
{
    console.log(emp1.bankaccounts[i])
}
emp1.name="Dhanunjaya"   //We can not change the name of the employee to dhanunjaya as it cant be writable
console.log(emp1.name)
emp1.bankaccounts[5]='canara Bank' //adding a new bank account to bank accounts
console.log("After adding the bank account")
for(let i in emp1.bankaccounts)
{
 console.log(emp1.bankaccounts[i])
} 
emp1.address='Ahmedabad'  //we can not change the address to ahmedabad
console.log(emp1.address) 
delete emp1.gender
console.log(emp1.gender)
delete emp1.id
console.log(emp1.id) //We can not delete id as it is non configurable


const emp2=Object.create(account,
    {
     id:{value:"TR391",writable:false,configurable:false,enumerable:true},
     name:{value:"Priyanka",writable:true,configurable:false,enumerable:true},
     salary:{value:70000,writable:false,configurable:false,enumerable:false},
     address:{value:"MARATHALLI",writable:true,configurable:false,enumerable:true},
     gender:{value:'F',writable:false,configuirable:true,enumerable:false},
     bankaccounts:{value:['SBI','Kotak','SBC','HDFC'],writable:true,configurable:false,enumerable:false},
})
console.log(Object.keys(emp2))
emp2.name='Wadekar'
emp2.salary=800000
delete emp2.name //Cannot be deleted
console.log(emp2.name);
console.log(emp2.salary)
delete emp2.bankaccounts[0]
for(let i in emp2.bankaccounts)
{
 console.log(emp2.bankaccounts[i])
}
    



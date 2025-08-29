//JS program to demonstrate the manipulation of items in objects
let emp1={id:23,name:'Suresh',dept:'Cloud',gender:'F',Address:'Brookefield'};
console.log(emp1);
const emp2=new Object();
emp2.id=21;
emp2.name='Arjun'
emp2.dept='Cyber Security'
emp2.gender='M';
emp2.Address='Whitefield'
console.log(emp1);
const emp3=new Object()
emp3.id=22;
emp3.name='Niharika'
emp3.dept='Devops'
emp3.gender='F'
emp3.Address='Koramangala'
emp3.height=5.9
console.log(emp3)
console.log(`The address of 2nd employee is ${emp3.Address}`)
//We can also create a function as an item inside an object
const empl=
{
    id:"IS192",
    name:'Praneet',
    gender:'M',
    dept:'Cloud',
    bankaccount:
    {

        balance:300000,
        showbalance:function()
        {
           console.log(`Your Balance: ${this.balance}`)
        },
        deposit:function(amt)
        {
        this.balance+=amt;
        this.showbalance() //this is used to refer to the function in the same object
        },
        withdraw:function(amt)
        {
          this.balance-=amt;
          this.showbalance()
        } 
    },
    address:'Whitefield'
};
console.log(empl);
console.log(empl.bankaccount.deposit(120000))




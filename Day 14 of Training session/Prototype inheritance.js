//Java script to demonstrate the prototype inheritance 
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
//We are using the bank account as a prototype for creating bankaccount for employees

const empl1=Object.create(account)
empl1.id="TR2133"
empl1.name="Trilok"
empl1.gender='M'
empl1.salary=700000,
empl1.address='Mumbai'
empl1.balance=empl1.salary
empl1.showbalance();
empl1.deposit(23131)
empl1.withdraw(349234)
empl1.takeloan(300000,12)

const empl2=Object.create(account)
empl2.id="TR2312"
empl2.name="Yashna"
empl2.gender='F'
empl2.salary=400000
empl2.address='Delhi'
empl2.balance=empl2.salary
empl2.showbalance()
empl2.withdraw(20000)
empl2.withdraw(270000)
empl2.takeloan(100000,3)
console.log(empl1)

//Program to demonstrate the objects methods in java script
const account={};
    Object.defineProperty(account,"balance",
    {
        value:0,
        writable:true,
        enumerable:true
    });
    Object.defineProperty(account,"deposit",
        {
           value:function(amt)
           {
            this.balance+=amt
            console.log("Deposited Successfully")
            this.showbalance()
           },enumerable:false
    }) 
   Object.defineProperty(account,"withdraw",
        {
           value:function(amt)
           {
            this.balance-=amt
            console.log("Withdrawn Successfully")
            this.showbalance()
           },writable:true,configurable:false,enumerable:false
    }) 
    Object.defineProperty(account,"showbalance",
        {
           value:function()
           {
            console.log(`Your Balance: ${this.balance}`)
            },writable:true,configurable:false,enumerable:false
    }) 
const emp1=Object.create(account)
Object.defineProperties(emp1,{
        id:{value:'CD732',writable:false,configurable:false,enumerable:true},
        name:{value:'Trilok',writable:false,configurable:false,enumerable:true},
        age:{value:23,writable:true,configurable:true,enumerable:false},
        department:{value:'Cyber Security',writable:true,configurable:false,enumerable:true},
        salary:{value:500000,writable:true,configurable:true,enumerable:false},
        address:{value:'Delhi',writable:true,configurable:false,enumerable:true},
        bankaccounts:{
        value:{
        HDFC:{accno:4058000124,IFSC:'HDIK0023',branch:'Whitefield'},
        ICICI:{accno:70784339481,IFSC:'ICIN826317',branch:'Marathahalli'}
        },writable:false,configurable:false,enumerable:true
    }
})
console.log(Object.keys(emp1))//returns the keys of the object emp1
console.log(Object.values(emp1))//returns the values of the object emp1
console.log('Details of employee 1')
for(let [key,value]of Object.entries(emp1))
{
    console.log(key,'-',value)
}
console.log('Bank accounts of employee 1 ')
for(const [bankname,bankdetails] of Object.entries(emp1.bankaccounts))
{
    console.log(bankname,bankdetails)
}
proto=Object.getPrototypeOf(emp1)
console.log(Object.getPrototypeOf(emp1))//used to get the protype object used
console.log(`Prototype of emp1 is account?`,proto==account)
console.log(Object.getOwnPropertyDescriptors(emp1))
console.log(Object.getOwnPropertyNames(emp1)) //returns the names of original properties of the object
console.log(Object.freeze(emp1))//Can not add new data to emp1
emp1.age=29
console.log((emp1))
console.log(`Is the employee 1 data frozen? ${Object.isFrozen(emp1)}`)
console.log(`Does emp1 have the property id? ${Object.hasOwn(emp1,"id")}`)
console.log(`Does emp1 have timesheets as property? ${Object.hasOwn(emp1,"timesheets")}`)
console.log(`Does emp1 have the property accounts? ${Object.hasOwn(emp1,"account")}`)
console.log(`Does emp1 have the property address? ${Object.hasOwn(emp1,"address")}`)
//Creating a new object emp2
const emp2=Object.assign({},account,emp1)
emp2.name="Deepika"
emp2.id='CD343'
emp2.address='Chennai'
emp2.department='Cloud'
emp2.age=emp1.age
delete emp2.bankaccounts
console.log(emp2)
console.log(`Can we add more properties to emp2? ${Object.isExtensible(emp2)}`)
console.log(`Is emp2 sealed? ${Object.isSealed(emp2)}`)
Object.preventExtensions(emp2)
console.log(`Can we now add more properties to emp2? ${Object.isExtensible(emp2)}`)
console.log(`Is emp1 sealed? ${Object.isSealed(emp1)}`)
console.log(`Can we add more properties to emp1? ${Object.isExtensible(emp1)}`)
console.log(`Are the ages of both the employees same? ${Object.is(emp1.age,emp2.age)}`)
empl2=Object.fromEntries(emp2)
console.log(empl2)


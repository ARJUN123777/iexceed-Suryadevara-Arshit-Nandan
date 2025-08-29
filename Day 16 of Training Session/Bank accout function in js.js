let bankaccount={}; 
Object.defineProperty(bankaccount,"balance",{get:function(){
    return this._balance;
},set:function(amt)
    {
        if(!this._balance)this._balance=0;
        //this.balance is used to call the function balance
        this._balance+=amt;  //this._balance is used to create an internal property to store the value
        
        console.log(`Deposited ${amt} new balance ${this._balance}`);
    }
}
);
bankaccount.balance=1000;
bankaccount.balance=5000; 
Object.defineProperty(bankaccount,"withdraw",{
    set:function(amt)
    {
        if(!this._balance)this._balance=0;
        if(amt>this._balance)
        {
            console.log("Insufficient balance");
        }
        else{
            this._balance-=amt;
            console.log(`withdraw ${amt} current balance${this._balance}`);
        }
 
}});
 
bankaccount.withdraw=2000;
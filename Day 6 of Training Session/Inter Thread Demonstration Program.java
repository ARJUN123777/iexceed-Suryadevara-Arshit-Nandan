//Program to demonstrate the interthread process in java
class atmcontent extends Thread
{
  String usr="Arjun";
  String pwd="ARJUN777123";
    int amt=20000;
    synchronized public void withdraw(int amt1)
    {
      if(this.amt<amt1)
      {
        System.out.println("Insufficient balance");
        try
        {
          System.out.println("Please deposit sufficient amount to withdraw .");
           wait();     //Makes a thread to wait until the thread recieves an alert message
        }catch(Exception e){};
      }
      this.amt-=amt1;
      System.out.println("Your Amount Balance: "+(this.amt));
      System.out.println("Happy Banking ");
    }
    synchronized public void deposit(int amt)
    {
      System.out.println("Deposit the Amount ");
      this.amt=amt;
      System.out.println("Deposit Done");
      notify(); //Used to send an alert signal to the thread that is in wait state.
    }
  }
class customer
{
  public static void main(String args[])
  {
    System.out.println("Welcome to Magadha Bank ");
    atmcontent atm=new atmcontent();
    new Thread()
    {
      public void run()
      {
       atm.withdraw(500);
      }
    }.start();
    new Thread()
    {
      public void run()
      {
        atm.deposit(12000);
      }
    }.start();
  }
}


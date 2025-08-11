//program to demonstrate threads in java
class myclass extends Thread
{
      /*myclass()
      {
        new Thread(this).start();
      }*/
      public void run()
      {
        System.out.println("Inside the run Method");
      }
}
class myclass1
{
    public static void main(String[] args)
    {
      myclass m1=new myclass();
      myclass m=new myclass();
      m.start();      //we cannot use the start method twice to start the same object
      m1.start();     //we can start the thread by using multiple objects
    }
}


//Another demonstration to show the usage of thread in java
class thread1 extends Thread
{
  Thread t=new Thread(this);        //to declare an objectin the thread we use the static block
  public void run()            //we have to declare the method as run menthod inorder to start the thread
  {
    System.out.println("Default Name of the Thread is "+t.getName());
    t.setName("i-exceed");   //changing the name of the thread
    System.out.println("Modified Name of the Thread is "+t.getName());
  }
}
class thread2
{
  public static void main(String args[])
  {

  Thread t=Thread.currentThread();   //creating an instance of the running thread 
  System.out.println("Thread in Main Method is "+t.getName());
  new thread1().start();

}

}

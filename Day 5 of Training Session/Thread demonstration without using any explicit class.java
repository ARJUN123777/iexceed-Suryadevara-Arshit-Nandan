//Program to to demonstrate the use of thread without using any skeleton class
class thread1 
{
  public static void main(String args[])
  {
    new Thread()
    { 
      public void run()
      {
        String st="Main class";
        for(int i=0;i<10;i++)
        {
            try{
           System.out.println("Main class");
           new Thread().sleep(1000);
           new Thread().join();
            }catch(InterruptedException E){};
        } 
      }
    }.start();
  }
}

class mythread extends Thread
{
    public void run()
    {
      String st="Loading";
      for(int i=0;i<=10;i++)
      {
        try{
        System.out.println("Skeleton class");
        this.sleep(1000);
      }catch(Exception e){};
    }
}
}
class newthread 
{
    public static void main(String args[]) throws InterruptedException
     {
          Thread t=Thread.currentThread();
          mythread obj=new mythread();
          obj.start();
          for(int i=0;i<=10;i++)
          {
            System.out.println("Main class");
            t.sleep(500);

    }
     }
  }


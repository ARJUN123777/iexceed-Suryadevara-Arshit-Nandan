class mythread extends Thread 
{
    public void run()
    {
        for(int i=0;i<=6;i++)
        {
            try{
            System.out.println("Skeleton class- "+i);
            this.sleep(1000);
            }catch(InterruptedException E){};
        }
    }
}
class drivingclass
{
    public static void main(String args[])
    {
        Thread t=Thread.currentThread();
        new mythread().start();
        for(int j=0;j<=6;j++)
        {
          try{
            System.out.println("Main class- "+j);
            t.sleep(1000);
          }catch(InterruptedException E){};
        }
    }
}

//Program to demonstrate yield method in threads
class mythread extends Thread{
    public void run()
    {
        for(int i=0;i<7;i++)
        {
            System.out.println(Thread.currentThread().getName()+" Iteration -"+i);
        }
    }
}
class newclass
{
    public  static void main(String args[])
    {
       mythread obj=new mythread();
       mythread obj1=new mythread();
       obj1.start();
       obj1.yield();
       obj.start();
       for(int i=0;i<7;i++)
       {
        System.out.println("Main Class Running");
       }
    }
}

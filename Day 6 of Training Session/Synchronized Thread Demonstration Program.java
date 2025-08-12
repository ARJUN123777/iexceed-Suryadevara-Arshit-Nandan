//Program to demonstrate the synchronization of thread in java
class content
{
    synchronized public void display(String msg) //It does not allow other threads to interrupt the current running thread but can not print the threads in the user defined sequence
    {
        System.out.println("*******");
        System.out.println(msg);
        System.out.println("*******");
        System.out.println("^=^");
    }
}
class mythread extends Thread
{
    String msg;
    content obj;
    mythread(content obj,String msg)
    {
        this.msg=msg;
        this.obj=obj;
        this.start();
    }
    public void run()
    {
        obj.display(msg);
    }
}
class drive
{
    public static void main(String args[])
    {
        content obj=new content();
        mythread t1=new mythread(obj,"Hi");
        try
        {
        t1.join();   //join function inthread allows to the current running thread to complete its execution and also it prints the threads in user defined sequence
        mythread t2=new mythread(obj,"Hello");
        t2.join();
        mythread t3=new mythread(obj,"How are you");
        t3.join();
        }catch(InterruptedException e){};
}
}


//Another program to demonstrate the use of synchronized block in java
class newcontent
{
    synchronized public void displaydetails()
    {
            System.out.println("     ^     ");
            System.out.println("    ^ ^    ");
            System.out.println("   ^ ^ ^    ");
            System.out.println("  ^ ^ ^ ^   ");
            System.out.println(" ^ ^ ^ ^ ^  ");
    }
}
class mythreads extends Thread
{
   newcontent obj;
   mythreads(newcontent obj)
   { this.obj=obj;
    this.start();
   }
   public void run()
   {
      obj.displaydetails();
   }
}
class drives 
{
    public static void main(String args[])
    {
       newcontent ob=new  newcontent();
       mythreads t1=new mythreads(ob);
       mythreads t2=new mythreads(ob);
       mythreads t3=new mythreads(ob);
    }
}
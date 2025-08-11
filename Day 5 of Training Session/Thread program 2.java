//Program to demonstrate the use of sleep state of threads in java
class thread1 extends Thread 
{
  public void run() {
    //this refers to the current Thread object
    System.out.println("Default Name of the Thread is " + this.getName());
    // Change the name of the current thread
    this.setName("i-exceed");
    System.out.println("Modified Name of the Thread is " + this.getName());
  }
}

class myclass
{
  public static void main(String[] args) 
  {
    Thread t = Thread.currentThread(); // Main thread
    System.out.println("Thread in Main Method is " + t.getName());

    // Start multiple threads
    thread1 t1 = new thread1();
    t1.start();
    try
    {
    t1.sleep(1000);
    }catch(InterruptedException e){};
    thread1 t2 = new thread1();
    t2.start();
    try
    {
    t2.sleep(1000);
    }catch(InterruptedException e){};
    thread1 t3 = new thread1();
    t3.start();
  }
}


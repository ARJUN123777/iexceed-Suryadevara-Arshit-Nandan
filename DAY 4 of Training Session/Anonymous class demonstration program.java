//program to demonstrate the use of Anonymous class in java
abstract class sample 
{
  abstract public void display();    
}
class demoano
{
    public static void main(String args[])
    {
        new sample()                   
        {
            public void display()      //Inorder to override the method the class/method must be declared as abstract or interface
            {
                System.out.println("Inside display method");
            }
        }.display();
    }
}

//Another Program to illustrate the use of anonymous class using the interface
interface students
{
    abstract public void displaystudentdetails(String sname,int age,int cl,char gender,String address);
}
class college implements students
   {
    public static void main(String [] args)
    {
      new students()
      {
        public void displaystudentdetails(String sname,int age,int cl,char gender,String address)
        {
            System.out.println("Name of the student : "+sname);
            System.out.println("Age of the Student : "+age);
            System.out.println("Class of the Student : "+cl);
            System.out.println("Gender of the Student : "+gender);
            System.out.println("Address of the Student : "+address);
        }
      }.displaystudentdetails("Harsha",21,9,'M',"Guntur");
    }
}
//program to import the content from the userdefined package
package studentpackage.java;
import mypackage.java.studentaddress;
class student
{
    String sname,gender,cl;
    private int roll,age;
    private float height;
    student(int roll,String name,String cl,String gender,int age,float height)
    {
        this.roll=roll;
        this.sname=name;
        this.cl=cl;
        this.gender=gender;
        this.age=age;
        this.height=height;
        displaydetails1();
        new studentaddress("G02","SUAVITY OTIUM","AKSHAYANAGAR",570034);
        
    }
    public void displaydetails1()
    {
        System.out.println("Student Details");
        System.out.println("Roll No- "+roll);
        System.out.println("Name- "+sname);
        System.out.println("Class- "+cl);
        System.out.println("Gender- "+gender);
        System.out.println("Age- "+age);
        System.out.println("Height- "+height);
    }
}
public class drivingclass
{  
    public static void main(String args[])
    {
        new student(001,"Nidhi Reddy","A","F",20,5.10f);
    }
}

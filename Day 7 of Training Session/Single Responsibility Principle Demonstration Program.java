//Program to demonstrate the single responsibility principle in java
class average
{
    int s1,s2,s3;
    average(int s1,int s2,int s3)
    {
       this.s1=s1;
       this.s2=s2;
       this.s3=s3;
       System.out.println("The Average of the Student is "+averages());
    }
    int averages()
    {
    return (s1+s2+s3)/3;
    }
}
class subjects
{
    String s1,s2,s3;
    subjects(String s1,String s2,String s3)
    {
       this.s1=s1;
       this.s2=s2;
       this.s3=s3;
    }
}
class driverclass
{
    public static void main(String args[])
    {
        new subjects("Maths","Physics","Chemistry");
        new average(78,81,92);
    }
}

//Program to demonstrate the encapsulation in java
class baseclass 
{
    private int rollno;
    private String st;
    private char ch;
    private double height;
    public void setdetails(int roll,String st,char ch,double h)
    {
        this.rollno=roll;
        this.st=st;
        this.ch=ch;
        this.height=h;
    }
    public int getrollno()
    {
        return rollno;
    }
    public String getname()
    {
        return st;
    }
    public char getgender()
    {
        return ch;
    }
    public double getheight()
    {
        return height;
    }
}
class driverclass
{
    public static void main(String args[])
    {
        baseclass b=new baseclass();
        b.setdetails(1,"TOM",'M',5.11);
        System.out.println("Roll no: "+b.getrollno());
        System.out.println("Name :"+b.getname());
        System.out.println("Gender :"+b.getgender());
        System.out.println("Height :"+b.getheight());
    }
}

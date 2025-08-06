//Program to display the detials of hr and the finance managers of the company
class company {
    static String companyname="iexceed",city="Bangalore";
    static int pos=1;
    company()
    {
        display();
    }
    public void display()
    {
        System.out.println("Welcome to "+companyname+"!.We are the "+pos+" Fintech Company in "+city );
    }
}
class hr extends company
{  
    String hrname,pos;
    hr(String hrname,String pos)
    { 
        super();
        this.hrname=hrname;
        this.pos=pos;
        displayhrdetails();
    }
    public void displayhrdetails()
    {
        System.out.println("Hi I am "+hrname+" the Head of "+pos);
    }
}
class finance extends company
{
    String fin,pos;
    finance(String fin,String pos)
    {
        super();
        this.fin=fin;
        this.pos=pos;
        displaydetails();
    }
    public void displaydetails()
    {
        System.out.println("Hi I am "+fin+" the Head of "+pos);
    }
}
class mainprogram
{
    public static void main(String args[])
    {
      hr obj=new hr("Sneha","HR Operations");
      finance obj1=new finance("Harsha","Finance Operations");
    }
}

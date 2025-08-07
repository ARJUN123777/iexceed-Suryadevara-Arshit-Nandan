//program to demonstrate the composition relationship part of in java
//This is a program to demonstrate the use of composition which acts a strong relationship between the the classes
class apartment 
{
    private final rooms room ;    //using the final keyword to declare the the object for the class rooms
    private String name;          
    private String address ;                    
    private int totalfloors;
    apartment(String n,int f,String a)
    {
        this.name=n;
        this.totalfloors=f;
        this.address=a;
        displaydetails();         
        room= new rooms();       //calling the method from the class known as rooms
    }
   private void displaydetails()
   {
      System.out.println("Name of the Apartment: "+name);
      System.out.println("Total no of floors: "+totalfloors);
      System.out.println("Address :"+address);
   }
}
class rooms
{
   int total=10;
   int r1=5;
   int r2=5;
   String str1="14k";
   String str2="20k";
   rooms()
   {
    displayroomdetails();
   }
   private void displayroomdetails()
   {
    System.out.println("There are total "+total+" rooms in each floor");
    System.out.println("No of 1BHK Rooms "+r1);
    System.out.println("No of 2BHK Rooms "+r2);
    System.out.println("The Cost of 1BHK Rooms is "+str1);
    System.out.println("The Cost of 2BHK Rooms is "+str2);
   }
}
class driverclass
{
    public static void main(String args[])
    {
        new apartment("PARADISE",8,"HEBBALA");
    }
}

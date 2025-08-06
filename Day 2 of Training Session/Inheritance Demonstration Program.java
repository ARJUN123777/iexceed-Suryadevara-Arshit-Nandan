class car
{
    String  nameofCompany;
    boolean isAvailable;
 
    car(String nameofCompany,boolean isAvailable)
	{
	   this.nameofCompany=nameofCompany;
	   this.isAvailable=isAvailable;
 
	}
 
    public void getCarDetails()
	{
	  System.out.println("Company "+nameofCompany);
	  System.out.println("Availability "+isAvailable);
 
	}
}
 
   class Scorpio extends car  // derived class
     {
	 String carName,modelName,color;
 
	 Scorpio(String carName,String modelName,String color)
	  {
	     super("Mahindra",true);
	     this.carName=carName;
	     this.modelName=modelName;
	     this.color=color;
	   }
 
	  public void displayCarModel()
		{
	           System.out.println("Name of the car "+carName);
		   System.out.println("Model "+modelName);
		   System.out.println("Color "+color);
		}
      }	
 
    class demoinher1
     {
       public static void main(String ads[])
	{
	   Scorpio c1=new Scorpio("Scorpio","vlx","black");
	   c1.getCarDetails();
	   c1.displayCarModel();				
	}
     
     }	
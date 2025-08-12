interface bikefuel
{
 public void petrol();
}
abstract class BMW
{
    String type,model;
    int cost;
    abstract public void manufacturedetails( );
    abstract public double milage();
    abstract public void diesel();
}
class bmwcar extends BMW
{
    bmwcar(String car,String model)
    {
        this.type=car;
        this.model=model;
        manufacturedetails();
        diesel();
        System.out.print("Its gives a mileage of ");
        double m=milage();
        System.out.println(m+"Kmpl");
    }
    public void manufacturedetails()
    {
        this.cost=100000000;
        System.out.println("This BMW Car Model was launched in the Year- 2009");
        System.out.println("The price of this car is "+this.cost+"Rs");
        System.out.println("It has a Horse power of 535KW");
    }
    public double milage()
    {
        return 49.75;
    }
    public void diesel()
    {
        System.out.println("This BMW Car Model takes only Diesel");
    }
}
class bmwbike extends BMW implements bikefuel
{
   bmwbike(String type,String model)
   {
    this.type=type;
    this.model=model;
    manufacturedetails();
    petrol();
    System.out.print("It gives a mileage of ");
    double m=milage();
    System.out.println(m+"Kmpl");
   }
   public void manufacturedetails()
   {
    this.cost=1000000;
    System.out.println("This BMW Bike Model was launched in the Year-2015 ");
    System.out.println("The price of this bike is "+this.cost+"Rs");
    System.out.println("It has 4 engine Cylinder");
   }
   public double milage()
   {
    return 15.6;
   }
   public void petrol()
   {
    System.out.println("This BMW bike Model takes only Petrol");
   }
}
class drives
{
    public static void main(String args[])
    {
        new bmwcar("car","BMW M5");
        new bmwbike("bike","BMW S 1000 RR");
    }
}

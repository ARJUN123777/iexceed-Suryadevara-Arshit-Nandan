class address 
{
    String city,area;
    int pincode;
    address(String area,String city,int pincode)
    {
        this.area=area;
        this.city=city;
        this.pincode=pincode;
    }
    public void displaydetails()
    {
        System.out.println("Area "+area);
        System.out.println("City "+city);
        System.out.println("Pincode "+pincode);
    }
}

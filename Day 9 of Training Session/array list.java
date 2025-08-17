import java.util.ArrayList;
import java.util.List;
class arraylist
{
    public static void main(String args[])
    {
        List<String> mylist=new ArrayList<String>();
        mylist.add("Shawshank Redemption");
        mylist.add("Empire of the Sun");
        mylist.add("The Prestige");
        mylist.add("The Departed");
        mylist.add("Rain Man");
        System.out.println(mylist);
         for(String i:mylist)
        {
            System.out.println(i);
        }
        mylist.add("Insomnia");
        System.out.println("Before removing the elements");
        System.out.print(mylist);
        System.out.println("\n The First Element of the array list is "+mylist.getFirst()); //Returns the first element of the list
        mylist.remove(2);
        mylist.remove("The Departed");
        System.out.println("After removing the elements");
        for(String i:mylist)
        {
            System.out.print(i.toLowerCase()+",");
        }
        System.out.println("\n"+mylist.get(2));  //get method returnds the element at the given position
        System.out.println(mylist.get(3));
    }
}

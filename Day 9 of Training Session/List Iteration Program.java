//Program to iterate the elements in a list and linked list
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
class listiterator
 {
    List<String> list1=new LinkedList<String>();
    LinkedList mylist=new LinkedList(); 
    listiterator()
    {
        mylist.add(0.981);
        mylist.add(0.272);
        mylist.add(34.293);
        mylist.add(45.238);
        mylist.add(1.384);

        list1.addFirst("Augumented Reality");
        list1.addLast("Virtual Reality");
        list1.addLast("Holograms");
        list1.addFirst("Robotic Automation");
        list1.addFirst("Robo Wars");

        //To Display the items in a list we use list iterator
        Iterator litr=mylist.iterator();
         while(litr.hasNext())
        {
            System.out.println(litr.next());
        }
        System.out.println("The Last element of list1 is "+list1.getLast());
        System.out.println(list1.getLast());
        //Iterating the items of list1
        ListIterator lit=list1.listIterator();
        while(lit.hasNext())
        {
              System.out.println(lit.next());
        }
    }
}
class drivingclass
{
    public static void main(String args[])
    {
        new listiterator();
    }
}

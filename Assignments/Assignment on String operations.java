import java.util.lang;
import java.util.*;
class stringoperations
{
    public static void main(String args[])
    {
    System.out.print("Enter your string: ");
    String st1="Supercalifragilisticexpialidocius";//Immutable String
    StringBuffer st2=new StringBuffer(" He is "); //Mutable String
    System.out.println("Is string1 empty or not ?"+st1.isEmpty());
    System.out.println("The Substring of string1 is "+st1.substring(0,5));
    System.out.println("The Uppercase of string1 is "+st1.toUpperCase());
    System.out.println("The lower case of string1 is "+st1.toLowerCase());
    System.out.println("The value of string2 is "+st2.append(st1.substring(0,5)));
    System.out.println("Are String1 and String2 have the same value? "+st1.equals(st2));
    System.out.println("Does the word super is present in st1? "+st1.contains("fragile"));
    System.out.println("The new Modified value of String2 is "+st2.append(" man   "));
    System.out.println("The next modfied value of String2 is "+(st2.toString()).trim());
    System.out.println("Removing value from string2-"+st2.delete(0,6));
    }
}


//Program to count the milliseconds taken by the processor tpo process the literal string and  stringbuffer
class stringclass
{
    public String literal()
    {
        String st1="Gateway";
        for(var v=0;v<100000;v++)
        {
            st1+=" of India";
        }
        return st1;
    }
    public String stringbuffer()  //String Buffer is not thread safe  i.e two threads can access the string at a time
    {
        StringBuffer sb=new StringBuffer("Empire");
        for(var v=0;v<1000000;v++)
        {
            sb.append(" of the Sun");
        }
        return sb.toString();
    }
    public String stringbuilder()  //String builder is Thread safe i.e two threads can not access the string at a time
    {
      StringBuilder sbl=new StringBuilder("Shawshank ");
      for(var v=0;v<1000000;v++)
      {
        sbl.append(" Redemption");
      }
      return sbl.toString();
    }
}

class driverclass
{
 public static void main(String args[])
 {
   stringclass sc=new stringclass();
   long stc1=System.currentTimeMillis();
   sc.literal();
   System.out.println("The Time Taken to Process the string literal is-"+(System.currentTimeMillis()-stc1));
   long stc2=System.currentTimeMillis();
   sc.stringbuffer();
   System.out.println("The Time taken to process the String buffer is-"+(System.currentTimeMillis()-stc2));
   long stc3=System.currentTimeMillis();
   sc.stringbuilder();
   System.out.println("The Time taken to process the String Builder is- "+(System.currentTimeMillis()-stc3));
 }
}

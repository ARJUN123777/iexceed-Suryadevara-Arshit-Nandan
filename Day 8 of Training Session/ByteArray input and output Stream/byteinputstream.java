//Program to perform the bytearrayinputstream operations in java
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
class byteinputstream 
{
   public static void main(String args[]) throws Exception
   { 
       int i=0;
       byte x[]={97,98,99,100,101,102};
       ByteArrayInputStream bin=new ByteArrayInputStream(x);
       System.out.println((char)bin.read()); //It prints the first element of the byte stream
       System.out.println(bin.available());  //It prints the no of elements present in the byte stream 
       while((i=bin.read())!=-1)
       {
        System.out.println((char)i);
       }
       System.out.println(bin.available());//It returns null as all the elements have been read from the bytestream
   }
}

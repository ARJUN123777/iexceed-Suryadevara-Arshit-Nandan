//Program to demonstrate the buffered inputoutputstream
import java.io.*;
class bufferedinputoutputstream
{
    public static void main(String args[])throws Exception
    {
        BufferedOutputStream bout=new BufferedOutputStream(new FileOutputStream(new File("D:\\OneDrive\\Desktop\\Buffer File.txt")));
        bout.write("The data consists of the internal buffer created for the bufferedoutputstream and Bufferedinput stream".getBytes());
        bout.close();
        BufferedInputStream bin=new BufferedInputStream(new FileInputStream(new File("D:\\OneDrive\\Desktop\\Buffer File.txt")));
        int i=0;
        while((i=bin.read())!=-1)
        {
            System.out.print((char)(i));
        }
    }
}

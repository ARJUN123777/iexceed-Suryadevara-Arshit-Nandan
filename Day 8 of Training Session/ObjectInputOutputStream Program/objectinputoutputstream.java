//Program to demonstrate the objectinput and output stream
import java.io.*; //objectinput and outputstream uses the concept of serialization where the objects are converted into the byte form
class students implements Serializable { // Serilization is done by utilizing the Serializable keyword
    String stname, address;
    char gen, section;
    int stid, cl;
    students(int id, String name, int cl, char sec, char gen, String ad) {
        this.stid = id;
        this.stname = name;
        this.cl = cl;
        this.section = sec;
        this.gen = gen;
        this.address = ad;
    }
    public String studentdetails()
    {
        return "ID :"+this.stid+", Student Name :"+this.stname+", Class :"+this.cl+", Section :"+this.section+", Gender :"+this.gen+", Address :"+this.address+"\n";
    }
}

class objectinputoutputstream {
    public static void main(String args[]) throws Exception 
    {
        students st1 = new students(1, "Nidhi Reddy", 10, 'A', 'F', "Bengaluru");
        students st2 = new students(46, "Pranit Reddy", 10, 'C', 'M', "Bengaluru");
        students st3 = new students(59, "Pranay Reddy", 10, 'D', 'M', "Hyderabad");
        ObjectOutputStream fout = new ObjectOutputStream(new FileOutputStream(new File("D:\\OneDrive\\Desktop\\10th Class List.txt")));
        fout.writeObject(st1);
        fout.writeObject(st2);
        fout.writeObject(st3);
        fout.close();
        ObjectInputStream fin = new ObjectInputStream( new FileInputStream(new File("D:\\OneDrive\\Desktop\\10th Class List.txt")));
        try
        {
        while(true)
        {
            students all = (students) fin.readObject();
            System.out.println(all.studentdetails());
        }
    }catch(EOFException e){};
    }
}

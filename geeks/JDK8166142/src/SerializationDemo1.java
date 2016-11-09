import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by ntv on 9/16/2016.
 */

public class SerializationDemo1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
       Employee e = new Employee("a", "12");
        //Employee e = Employee.getInstance();
        //e.sal = 100;
        System.out.println("Hash="+e.hashCode());
        FileOutputStream f = new FileOutputStream("se.txt");
        ObjectOutputStream o = new ObjectOutputStream(f);
        o.writeObject(e);
        e.setName("sdd");
        o.writeObject(e);
        o.close();
        f.close();
        System.out.println("serialized");

        FileInputStream f1 = new FileInputStream("se.txt");
        ObjectInputStream o1 = new ObjectInputStream(f1);
        Employee e1 = (Employee) o1.readObject();
        System.out.println(e1.name);
        System.out.println("Hash1="+e1.hashCode());
        //System.out.println(e1.getAge());
       // System.out.println(e1.sal);
        System.out.println("nooo="+e1.mgrName);


    }
}

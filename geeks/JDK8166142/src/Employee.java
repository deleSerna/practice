import java.io.Externalizable;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.Instant;

/**
 * Created by ntv on 9/16/2016.
 */

class Manager implements Serializable{
    String mgrName ;
    Manager() {
        mgrName = "Mgrrs";
    }
  /* private void writeObject(ObjectOutputStream o) throws NotSerializableException{
       System.out.println("MangerWrite");
       throw new NotSerializableException();
   }*/

}
public class Employee extends Manager implements Serializable {
    public static final long serialVersionUID = -1814239825517340641L;
    static final Employee  emp = new Employee("sw", "40");
    String name;
    private String age;
    public static  int sal;
   // Manager m;
    public Employee() {}

    public Employee(String name, String age) {

        this.name = name;
        this.age = age;
        this.sal = 200;
        this.mgrName = "asd";
        //m = new Manager();
    }

   /* public static Employee getInstance () {
        return emp;
    }*/


    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
       // this.mgrName = name;
    }
     private void writeObject(ObjectOutputStream o) throws IOException {
        System.out.println("herreee in writeObje");
         o.defaultWriteObject();
        o.writeChars(name);
         o.writeChars(mgrName);
       // o.close();
    }

    private Object writeReplace() {
        System.out.println("herreee in writeReplace");
        return new Employee("qw", "123");
    }


     private void readObject(ObjectInputStream o) throws IOException {
         System.out.println("read Obj1"+Instant.now());
       //setAge(o.readLine());
         setName(o.readLine());
         mgrName = o.readLine();
         System.out.println("read Obj2");
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeChars(name);
    }
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
       setName(in.readLine());
      // mgrName = in.readLine();
    }

   /* public Object readResolve() {
        System.out.println("read resolve"+ Instant.now());
        return emp;
    }*/


}
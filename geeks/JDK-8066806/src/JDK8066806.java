

import jdk.internal.org.objectweb.asm.ClassWriter;
import static jdk.internal.org.objectweb.asm.Opcodes.*;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.regex.Matcher;

/**
 * Created by ntv on 6/2/2016.
 */

public class JDK8066806{


    public static void main(String[] args) throws Throwable {
        MethodHandle mh = MethodHandles.lookup().findVirtual(String.class, "concat" , MethodType.methodType(String.class, String.class));
        String out = (String) mh.invokeExact("a","b");
        //System.out.println(out);
        MethodHandle identity_MH = MethodHandles.identity(String.class);
       // System.out.println((String)identity_MH.invokeExact("1"));
        String path =
                "{     \"fields\": {        \"project\":        {           \"key\": \"JCK\"        },        \"summary\": \"Dev Test Report for JCK Report\",        \"description\": \"Ignore Test Report\\\\\\n\\\\\\nSolaris 10 machine with SPARC-CPU the issue doesnt occur.\\\\\\nSolaris 10 machine with SPARC-CPU the issue doesnt occur.\\\\\\n\",        \"customfield_10008\": 405,         \"labels\": [  \"bugdb_24318246\" , \"hook5:INTERNAL\" ,  \"licbug\"    ], \"components\": [ {\"name\": \"jck-tools\"} ],\"customfield_10";
        path = path.replaceAll("[\\\\]+", "\\\\");
        System.out.println(path);
        path = path.replaceAll("[\\\\n]+", "\n");
        System.out.println(path);
        /* String[] a = path.split("\\\\n");
       for (String m: a) {
            System.out.println(m);
       }*/



    }
}

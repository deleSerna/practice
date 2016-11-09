import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.net.URL;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by ntv on 8/8/2016.
 */
class B {
    private void m() {}

}
public class A {

//Number

    /*static void staticMethod() {
    }

    private void privateMethod() {
    }*/

    public static void main(String[] args) throws Throwable{
        List<Integer> l= new ArrayList<>();
        l.add(1);
        l.add(2);
        l.stream().collect(Collectors.toMap(Function.identity(), x -> x.hashCode())).
                 forEach((k,v) -> System.out.println(""+k +"va"+v));
      /* for(Map.Entry s: m.entrySet()) {
           System.out.println(""+s.getKey() +"va"+s.getValue());
        }*/
      /*  try {
        Predicate<Integer> p = (a -> a > 0);
        p.test(3);
        Runnable r = () -> System.out.println("");
       // MethodHandle m = MethodHandles.lookup().findSpecial(B.class,"m", MethodType.methodType(void.class), B.class);
        MethodHandles.Lookup lookup = MethodHandles.publicLookup();
       // MethodHandle mh = lookup.findVirtual(String.class, "concat", MethodType.methodType(String.class, String.class));
        MethodHandle mh = lookup.findStatic(String.class, "valueOf", MethodType.methodType(String.class, char.class));
        String output = (String) mh.invokeExact('c');*/
    }
}

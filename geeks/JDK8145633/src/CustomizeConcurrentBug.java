/**
 * Created by ntv on 8/30/2016.
 */
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodType;

public class CustomizeConcurrentBug {
    public static void main(String[] args) throws Throwable {

        // Run with: -Djava.lang.invoke.MethodHandle.CUSTOMIZE_THRESHOLD=0

        Lookup lookup = MethodHandles.publicLookup();
        MethodHandle mh = lookup.findStatic(CustomizeConcurrentBug.class, "print",
                MethodType.methodType(void.class, String.class, String.class));
        MethodHandle mh1 = MethodHandles.insertArguments(mh, 0, "A");

        Thread1 t1 = new Thread1(mh1);
        t1.start();
    }

    public static void print(String x, String y) {
        System.out.printf("(%s, %s)%n", x, y);
    }

    public static class Thread1 extends Thread {
        public final MethodHandle mh;
        public final Thread2 thread2;

        Thread1(MethodHandle mh) {
            super("Thread 1");
            this.mh = mh;
            this.thread2 = new Thread2(mh);
        }

        @Override
        public void run() {
            try {
                mh.invokeExact("B");
                MethodHandles.insertArguments(mh, 0, "D").invokeExact();
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }

    public static class Thread2 extends Thread {
        public final MethodHandle mh;

        Thread2(MethodHandle mh) {
            super("Thread 2");
            this.mh = mh;
        }

        @Override
        public void run() {
            try {
                mh.invokeExact("C");
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }
}
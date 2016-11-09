import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

/**
 * Created by ntv on 5/11/2016.
 */
public class OverLapSubProb {
    int[] arr;

    OverLapSubProb(int n) {
        IntUnaryOperator a = (i) -> {return -1;};
      //  arr = new int[n];
       // Arrays.setAll(arr,a);
        arr = IntStream.rangeClosed(0, n)
                .map(a)
                .toArray();
    }

    /**
     *  Return the result using Memoized technique(top down)
     * @param n
     * @return
     */
    int fib(int n) {
        if (arr[n] == -1) {
            if(n <= 1) {
                arr[n] = n;
            } else {
                arr[n] = fib(n -1 ) + fib(n-2);
            }
        }
        return arr[n];
    }

    /**
     * Return the fib(n) using Tabulation(bottom up) approach
     * @param n
     * @return
     */
    int fib1(int n) {
        arr[0] = 0;
        arr[1] = 1;
        for(int i = 2; i <= n; i++) {
            arr[i] = arr[i -1] + arr[ i - 2];
        }

        return arr[n];
      }

    public static void main(String[] args) {
        System.out.println("Enter the number");
        Scanner inp = new Scanner(System.in);
        int n = inp.nextInt();
        OverLapSubProb olsp = new OverLapSubProb(n);
        System.out.println("Anser="+olsp.fib(n));
    }
}

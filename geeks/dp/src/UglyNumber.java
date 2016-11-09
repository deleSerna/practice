import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * Created by ntv on 5/11/2016.
 * Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence
 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, …
 shows the first 11 ugly numbers. By convention, 1 is included.
 Write a program to find and print the 150’th ugly number.
 */
public class UglyNumber {
   // Predicate isFactor = (i) -> i
   static IntStream factorsOf(int n) {
        return IntStream.range(2, (int) Math.sqrt(n) + 1).filter(i -> n % i == 0);
    }

    static boolean isPrime(int n) {
        return IntStream.range(2, (int) Math.sqrt(n) + 1).filter(i -> n % i == 0).findFirst().isPresent() == false ;
    }

    static boolean isTTF(int n) {
       return (n == 2 || n == 3 || n == 5);
    }

    static  boolean isUgly(int n) {
        return factorsOf(n).filter(UglyNumber::isPrime).filter(UglyNumber::isTTF).count() == 0;
    }
    public static void main(String[] args) {
        System.out.println("Enter how many'th Ugly number you w ant to find ");
        Scanner inp = new Scanner(System.in);
        int n = inp.nextInt();
       int result =  IntStream.iterate(0, i -> i + 1).filter(UglyNumber::isUgly).skip(149).findFirst().orElseGet(() -> -1);
        System.out.println(n+"th ugly num =" +result);

       // Predicate<Integer> isFactor = factorsOf(n).filter(isPrime)
    }
}

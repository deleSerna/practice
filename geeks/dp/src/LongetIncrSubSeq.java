import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by ntv on 5/12/2016.
 * The longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence such
 * that all elements of the subsequence are sorted in increasing order.
 * For example, length of LIS for { 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 */
public class LongetIncrSubSeq {
    static ArrayList<Integer> a = new ArrayList<>();
    int[] m;

    int lis() {
        ArrayList<ArrayList<Integer>> aListStr = new ArrayList<ArrayList<Integer>>();
        int numList = 0;
        boolean added = false;
        for (Integer i : a) {
            added = false;
            if (numList == 0) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i);
                aListStr.add(temp);
                numList++;
            } else {
                for (ArrayList<Integer> j : aListStr) {
                   if (j.get(j.size() - 1) < i) {
                        j.add(i);
                        added = true;
                        // break;
                    }
                }
                if (added == false) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    aListStr.add(temp);
                    numList++;
                }
            }
        }
        ArrayList<Integer> a = aListStr.stream().max(Comparator.comparing(List::size)).get();
        a.stream().forEach(System.out::println);
        return a.size();
    }

    public static void main(String[] args) {
        System.out.println("Enter the input as a string Separated by comma");
        Scanner inp = new Scanner(System.in);
        String seq = inp.next();

        Pattern.compile(",").
                splitAsStream(seq).
                mapToInt(Integer::parseInt).
                forEach(a::add);
        LongetIncrSubSeq l = new LongetIncrSubSeq();
        System.out.println(l.lis());
        //ArrayList<Integer> b = new ArrayList<>().add(i);
    }
}

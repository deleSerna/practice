import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by ntv on 5/16/2016.
 */
public class MinCostPath {
   // static int cost = 0;
    static int rowC = 0;
    static  int colC = 0;
    static int [][]arr = null;
    static int MCP(int i, int j, int cost) {
        if ( i > rowC - 1  || j > colC) {
            return cost;
        } else if ( i == rowC || j == colC) {
            return cost;
        } else {
            return (cost + min(MCP(i + 1, j, cost),
                    MCP(i, j + 1, cost),
                    MCP(i + 1, j + 1, cost)));
        }
    }

    static int min (int a, int b, int c) {
        int least = a;
        least = a < b ? (a < c ? a : c) : (b < c ? b : c);
        return least;
    }

    public static void main(String[] args) {
        Path p = Paths.get("inp/inp.txt");
        Scanner inp = null;
        try {
            inp = new Scanner(p);
            String a = "";
          //  String [] arr = null;
            List<Integer> m = null;
            while (inp.hasNextLine()) {
                a = inp.nextLine();
                m =  Pattern.compile(",").
                        splitAsStream(a).
                        peek(System.out::println).
                        map(Integer::parseInt).
                        //mapToInt(t->t).
                        collect(Collectors.toList());
                arr[rowC] = new int[m.size()];
                arr[rowC] = m.stream().mapToInt(t ->t).toArray();
                        //toArray(int[]::new);
                if (rowC == 0) {
                    colC = arr.length;
                } else if ( colC != arr[rowC].length){
                    throw new IOException("Invalid number of cloumns");
                }
                rowC++;
            }
       //     System.out.println(MCP(0, 0, arr[0][0]));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            inp.close();
        }
    }
}

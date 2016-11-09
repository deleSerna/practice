import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by ntv on 5/15/2016.
 */
public class EditDist {

    static int minDist(String s1, int n1, String s2, int n2) {
        if (n1 == 0) {
            return n2;
        } else if (n2 == 0) {
            return n1;
        } else if(s1.charAt(n1 - 1) == s2.charAt(n2 - 1)) {
            return minDist(s1, n1 - 1, s2, n2 - 1);
        } else {
            return 1 + min(minDist(s1, n1, s2, n2 - 1), //insert
                           minDist(s1, n1 - 1, s2, n2), //remove
                           minDist(s1, n1 - 1, s2, n2 - 1)); //replace
        }
    }



    static int  minDistDp( String s1, String s2) {
        int a[][] = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if( i == 0) {
                    a[i][j] = j;
                } else if (j == 0) {
                    a[i][j] = i;
                } else if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    a[i][j] = a[i - 1] [j - 1];
                } else {
                    a[i][j] = 1 + min(a[i][j - 1],
                                      a[i - 1][j],
                                      a[i - 1][j - 1]);
                }
            }
        }
        return a[s1.length()][s2.length()];
    }

    static int min (int a, int b, int c) {
        int least = a;
        least = a < b ? (a < c ? a : c) : (b < c ? b : c);
        return least;
    }

    public static void main(String[] args) {
        Path path = Paths.get("inp/inp.txt");
        Scanner inp = null;
        String n1 = null, n2 = null;
        try {
            inp = new Scanner(path);
            n1 = inp.nextLine();
            n2 = inp.nextLine();
           System.out.println(minDist(n1, n1.length(), n2, n2.length()));
           // System.out.println(minDistDp(n1, n2));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            inp.close();
        }


    }

}

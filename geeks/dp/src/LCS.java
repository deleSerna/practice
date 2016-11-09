import java.util.Scanner;

/**
 * Created by ntv on 5/14/2016.
 */
public class LCS {
     int lcsLen = 0;

    int max (int a , int b) {
       return  a >= b ? a: b;
    }
    int getLongestCommonSubSeq(String s1, int n1,  String s2, int n2) {
        /*if(n1 == 0 & n2 != 0) {
            if (s1.charAt(n1) == s2.charAt(n2)) {
                return 1 + getLongestCommonSubSeq(s1, 0, s2, n2 - 1);
            } else {
                return getLongestCommonSubSeq(s1, 0, s2, n2 - 1);
            }
        } else if(n1 != 0 & n2 == 0) {
            if (s1.charAt(n1) == s2.charAt(n2)) {
                return 1 + getLongestCommonSubSeq(s1, n1 -1 , s2, 0);
            } else {
                return getLongestCommonSubSeq(s1, n1 -1 , s2, 0);
            }
        } else if (n1 == 0 && n2 == 0) {
            if (s1.charAt(n1) == s2.charAt(n2)) {
                return 1 ;
            } else {
                return 0;
            }
        } else {*/
            if (n1 == 0 || n2 == 0) {
                return 0;
            } else if (s1.charAt(n1 - 1) == s2.charAt(n2 - 1)) {
                return  1 + getLongestCommonSubSeq(s1, n1 - 1, s2, n2 - 1);
            } else {
                return  max(getLongestCommonSubSeq(s1, n1 - 1, s2, n2), getLongestCommonSubSeq(s1, n1, s2, n2 -1));
            }
        }

    int getLcsDP(String s1, String s2) {
        int [] [] a = new int[s1.length()] [s2.length()];
        for(int i = 0; i< s1.length(); i++) {
            for (int j = 0; j <s2.length() ; j++) {
                if (i == 0 || j == 0) {
                    a[i][j] = 0;
                }
                else if (s1.charAt(i) == s2.charAt(j)) {
                    a[i][j] = a[i - 1] [j - 1] + 1;
                } else {
                    a[i][j] = max(a[i - 1] [j], a[i][j - 1]);
                }
           }
        }
        return a[s1.length() - 1][s2.length() - 1];

    }


    public static void main(String[] args) {
        System.out.println("Enter the 1st ");
        Scanner inp = new Scanner(System.in);
        String a = inp.next();
        System.out.println("Enter the 2nd ");
        String b = inp.next();
        LCS l = new LCS();
        System.out.println(l.getLongestCommonSubSeq(a,a.length() , b, b.length()));

    }
}

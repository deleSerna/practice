import java.util.Scanner;

/**
 * Created by ntv on 5/15/2016.
 */
public class PrintLCS {
    String [][] lcsArr = null;
    String LCS(String s1, int n1, String s2, int n2 ) {
        if(n1 == 0 || n2 == 0) {
           // lcsArr[n1][n2] = "";
            return "";
        } else if (s1.charAt(n1 - 1) == s2.charAt(n2 - 1)) {
            //lcsArr[n1][n2] = lcsArr[n1 - 1][n2 - 1] + s1.charAt(n1 - 1);
            return LCS(s1, n1 - 1, s2, n2 - 1) + s1.charAt(n1 - 1);

        } else {
            /*lcsArr[n1][n2] = (lcsArr[n1 - 1][n2].length() > lcsArr[n1][n2 - 1].length())?
                              lcsArr[n1 - 1][n2]:
                              lcsArr[n1][n2 - 1];*/
            String m1 = LCS(s1, n1 - 1, s2, n2);
            String m2 = LCS(s1, n1, s2, n2 - 1);
            return m1.length() > m2.length() ? m1 : m2;
        }
//        return lcsArr[n1][n2];

    }

    String LCSDP (String s1, String s2) {
        lcsArr = new String[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if(i == 0 || j == 0) {
                    lcsArr[i][j] = "";
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    lcsArr[i][j] = lcsArr[i - 1][j - 1] + s1.charAt(i - 1);
                } else {
                    lcsArr[i][j] = (lcsArr[i - 1][j].length() > lcsArr[i][j - 1].length())?
                            lcsArr[i - 1][j]:
                            lcsArr[i][j - 1];
                }
            }
         }
        return lcsArr[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter inp1");
        String s1 = inp.next();
        System.out.println("Enter inp2");
        String s2 = inp.next();
        PrintLCS p = new PrintLCS();
      //  String result =  p.LCS(s1, s1.length(), s2, s2.length());
        System.out.println("LCS="+p.LCSDP(s1, s2));
    }
}

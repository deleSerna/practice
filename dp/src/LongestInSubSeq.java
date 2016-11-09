
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ntv
 */
public class LongestInSubSeq {
    //int a[] = {10, 22, 9, 33, 21, 50, 41, 60, 80};
    int a[] = {10,  11, 12, 1,  2,   3,  4,  5 ,  6};
   // ArrayList <ArrayList<Integer>> lis = new ArrayList<>();
    int [][]b = new int[9][9];
    int [] lis = new int[9];

   // lis = Arrays.stream(lis).map(x ->0).toArray();
    int getMax() {
            Arrays.fill(lis, 1);
        int len = 0;
        int count = 0;
        for(int j = 1; j < a.length ; j++) {
        for(int i = 0; i < j ; i++) {
             if(a[j] > a[i] && lis[j] < lis[i] + 1 ) {
                 lis[j] = lis[i] + 1;
             } 
               
        }
         
    }
        int max = 0;
        for (int i = 0; i < 9; i++) {
               if( lis[i] > max ) {
                    max = lis[i];
                }
            }
        
            return max;
        }
        
    public static void main(String[] args) {
        LongestInSubSeq l = new LongestInSubSeq();
        System.out.println("Max="+l.getMax());
    }
}

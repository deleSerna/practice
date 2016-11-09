/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ntv
 */
public class MaximumSubArr {
    public static void main(String[] args) {
        int [] a = {5,  5, 10, 40, 50, 35};
        int incl = a[0];
        int excl = 0;
        int exclnew = 0;
        for(int i = 1; i < a.length; i++) {
            exclnew = (incl> excl)? incl: excl;
            incl = excl + a[i];
            excl = exclnew;
          
        }
        
        System.out.println("" +((incl> excl)? incl: excl));
    }
            
    
}

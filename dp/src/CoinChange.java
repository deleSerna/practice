/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ntv
 */
public class CoinChange {
    int [] s = {2,5,3,6};
    int m = 4;
    int getCoinChange(int n) {
        
        int [][] table = new int[n+1][m];
        int count = 0;
        for(int i = 0; i < m; i++) {
            table[0][i] = 1;
        }
        
        if( n < 0) {
            return 0;
        } else if( (n == 2) || (n == 0) )
            return 1;
        else {
            for (int i = 0; i < s.length; i++) {
                count = count + getCoinChange(n - s[i]);
                
            }
        }    
    return count;
    }
    
    public static void main(String[] args) {
     CoinChange c = new CoinChange();
     System.out.println(""+c.getCoinChange(5));
    }
    
}

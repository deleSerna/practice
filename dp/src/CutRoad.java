
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ntv
 */
public class CutRoad {
    int[] rodLength = {1,2,3,4,5,6,7,8};
    int[] rodPrices = {8 ,  20,   8,   9,  10,  17,  17,  20};
    int [] maxPrice = new int[9];
    int max(int a, int b) { return (a > b)? a : b;}
    int  getPrice(int l) {
        if(l<=0) {
            return 0;
        }
        int price = 0;
        for(int i = 0; i < l; i++) {
            price = max(price, rodPrices[i] + getPrice(l - i - 1));
        }
        return price;
    }
    
    
    int getDpPrice(int l) {
        
        for(int i = 1; i <= l; i++) {
            int price = 0;
            for (int j = 0; j < i; j++) {
                   price = max(price, rodPrices[j]+ maxPrice[i-j-1] );
                }
            
            maxPrice[i] = price;
            
        }
        return maxPrice[8];
                
       /*   int val[] = new int[n+1];
        val[0] = 0;
 
        // Build the table val[] in bottom up manner and return
        // the last entry from the table
        for (int i = 1; i<=n; i++)
        {
            int max_val = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++)
                max_val = Math.max(max_val, 
                                   rodPrices[j] + val[i-j-1]);
            val[i] = max_val;
        }*/
 
       // return val[n];
    }
    
    
    public static void main(String[] args) {
        System.out.println("Enter the rodLength");
        Scanner inp  = new Scanner(System.in);
        int l = inp.nextInt();
        System.out.println("Op="+new CutRoad().getDpPrice(l));
    }
    
}

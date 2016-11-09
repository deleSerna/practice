import sun.util.locale.provider.TimeZoneNameProviderImpl;

import java.util.TimeZone;

/**
 * Created by ntv on 5/19/2016.
 */
public class CoinChange {

    static  int getCoins(int[] a , int coin , int sum) {
        if (sum < 0 || (coin <= 0 && sum >= 0)) {
            return 0;
        }  else if (sum == 0) {
            return 1;
        } else{
            return getCoins(a, coin , sum - a[coin - 1]) + getCoins(a, coin - 1 , sum);
        }
    }


    static int getCoinsDP (int[] a , int coin , int sum) {
        int [][]table = new int [coin + 1][sum];
        for(int i = 0; i < coin; i++) {
            table[0][i] = 1;
        }



        return 0;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 5, 3, 6};
        System.out.println("count=" + getCoins(a, 4, 10));
    }
}

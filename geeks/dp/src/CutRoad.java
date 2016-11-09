/**
 * Created by ntv on 5/30/2016.
 */
public class CutRoad {
    int max (int i, int j) {
        return i > j? i : j;
    }

    int getMaxPrice(int [] price, int pos) {
        int maxVal = 0;
        if ( pos < 0)
            return 0;
        for (int i = 0; i< pos; i++) {
            maxVal =  max(maxVal, price[i] + getMaxPrice(price, pos - i -1));
        }
        return maxVal;
    }

    int getMaxPriceDp (int [] price, int pos) {
       int [][] b =  new int[pos][pos];

    }

    public static void main(String[] args) {
        int [] a = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
        int [] price = new int [] {1, 5, 8, 9, 10, 17, 17 ,20};
        CutRoad cr = new CutRoad();
        System.out.println("out="+cr.getMaxPrice(price, a.length));
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quick;

import java.util.Arrays;

/**
 *
 * @author ntv
 */
public class QuickSortI {
    
    int partition(int [] a, int low, int high) {
        int pivot = a[high];
        int i = low - 1;
        int temp;
        for(int j = low; j <= high; j++) {
            if(a[j] < pivot) {
                ++i;
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        a[high] = a[++i];
        a[i] = pivot;
        return i;
        
    }
    
    void sort(int [] a, int low, int high) {
        if(low < high) {
           int p = partition(a, low, high);
           sort(a,low,p-1);
           sort(a,p+1,high);
        }
 
    }
    
    public static void main(String[] args) {
        int [] a = {1,4,3,2};
        QuickSortI qui = new QuickSortI();
        qui.sort(a,0,3);
        Arrays.stream(a).forEach(System.out::println);
    }
    
    
}

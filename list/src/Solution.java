/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ntv
 */
import java.util.*;

class Solution {
        public int solution(int A, int B) {
            char[] digitsA = Integer.toString(A).toCharArray();
            char[] digitsB = Integer.toString(B).toCharArray();
            StringBuilder s = new StringBuilder();
            int min = (digitsA.length < digitsB.length)? digitsA.length: digitsB.length;
            int i = 0;
            for(; i < min; i++) {
                s.append(digitsA[i]).append(digitsB[i]);
                
            }
            if(digitsA.length < digitsB.length) {
                s.append(digitsB, i, digitsB.length - i);
            } else {
                s.append(digitsA, i, digitsA.length - i);
            }
            int result = Integer.parseInt(s.toString());
            if(result > 100_000_000)
                result = -1;
            return result;
        // write your code in Java SE 8
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();
        int A = 10000;
        int B = 999;
        
        System.out.println("A="+s.solution(A,B));
    }
}
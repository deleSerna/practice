
import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Paul loves bit arrays
Given a bit array of length 
N
N, with all bits initially initialized to 
0
0, you need to perform operations over this array. In each operation, you shall be given a single integer 
X
X, and you need to flip the bit at the
i
t
h
ith index of this array.

After performing every such operation, you need to find the size of the largest subarray of this array, where no two neighboring bits have the same value. Can you do it ?

Input Format :

The first line of input contains two space separated positive integers 
N
N and 
Q
Q representing length of bit array and number of operations you need to perform respectively. Each of the next 
Q
Q lines contains a positive integer 
X
X specifying the parameters of the 
i
t
h
ith operation.

Output Format :

Output 
Q
Q integers, one per line - the current length of longest subarray, where no two neighboring bits have the same value.

Input Constraints :

1
≤
N
≤
2
×
10
5
1≤N≤2×105

1
≤
Q
≤
2
×
10
5
1≤Q≤2×105

1
≤
X
≤
N
 * @author ntv
 */

import java.util.Arrays;
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
class TestClass {
    int N;
    int Q;
    
    int getLenghtOfAdjacentArray(int [] bitArray, int X) {
        int length = 1;
        int maxLength = 1;
        if( bitArray[X - 1]  == 0) {
             bitArray[X - 1] = 1;
        } else {
            bitArray[X - 1] = 0;
        }
        for(int i = bitArray.length - 2; i >= 0 ; i--) {
            if(bitArray[i] != bitArray[i + 1]) {
                length++;
            } else {
                if(length > maxLength)
                    maxLength = length;
                length = 1;
            }
        } 
        return maxLength;
    }
    
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        */
        TestClass test = new TestClass();
        //Scanner
        Scanner s = new Scanner(System.in);
        test.N = s.nextInt();
        int X ;
        int [] bitArray;
        if((test.N >= 1) && (test.N <= 2 * 1_000_00) ) {
            test.Q = s.nextInt();
            if((test.Q >= 1) && (test.Q <= 2 * 1_000_00) ) {
                bitArray = new int[test.N];
                for (int i = 0; i < test.Q; i++) {
                     X = s.nextInt();
                     if( X >= 1 && X <= test.N) {
                         System.out.println(test.getLenghtOfAdjacentArray(bitArray, X));
                     } else {
                         System.out.println("Bad Value of X: Accepted Values 1 to " + test.N );
                 }
        }
            } else {
                System.out.println("Bad Value of Q: Accepted Values 1 to " + (2*1_000_00 ));
            }    
            
        } else {
            System.out.println("Bad Value of N: Accepted Values 1 to " + (2*1_000_00 ));
            
        }    

    }
}  

    


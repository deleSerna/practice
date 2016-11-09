/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forkJoinPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 *
 * @author ntv
 */
public class RecursiveTask1 {
    
    static class RecursiveT extends RecursiveTask<Integer> {
        int threshold;
        public RecursiveT(int threshold) {
            this.threshold = threshold;
        }
        
        public Integer compute() {
            if( this.threshold > 12) {
                System.out.println("Splitting threshold" + this.threshold);
                List<RecursiveT> rec = new ArrayList<RecursiveT>();
                rec.add(new RecursiveT(this.threshold/2));
                rec.add(new RecursiveT(this.threshold/2));
                for(RecursiveT r : rec) {
                    r.fork();
                }
                int result = 0;
                  for(RecursiveT r : rec) {
                    result = result + r.join();
                }
                return result;
                
            } else {
                System.out.println("doing the work alone");
                return this.threshold * 3;
            }
        }
    }
    
    public static void main(String[] args) {
        ForkJoinPool fp = new ForkJoinPool(4);
        System.out.println("Ans="+fp.invoke(new RecursiveT(30)));
    }
    
}

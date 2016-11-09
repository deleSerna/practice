/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forkJoinPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 *
 * @author ntv
 */
public class RecursiveAct {
    
    static class RecursiveAc extends RecursiveAction {
        int threshold;
        public RecursiveAc(int threshold) {
            this.threshold = threshold;
        }
        
        public void compute() {
            if( this.threshold > 12) {
                System.out.println("Splitting threshold" + this.threshold);
                List<RecursiveAc> rec = new ArrayList<RecursiveAc>();
                rec.add(new RecursiveAc(this.threshold/2));
                rec.add(new RecursiveAc(this.threshold/2));
                for(RecursiveAc r : rec) {
                    r.fork();
                }
            } else {
                System.out.println("doing the work alone");
            }
        }
    }
    
    public static void main(String[] args) {
        ForkJoinPool fp = new ForkJoinPool(4);
        fp.invoke(new RecursiveAc(30));
    }
    
}

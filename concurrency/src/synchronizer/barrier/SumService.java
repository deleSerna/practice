

/**
 *
 * @author ntv
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package synchronizer.barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ntv
 */
public class SumService implements Runnable {
    CyclicBarrier cb;
    int pos, start, end;
    int sumArr[],  valueArr[];
    public SumService(CyclicBarrier c, int [] sumArr, int [] valueArr, int pos, int start, int end) {
        cb = c;
        this.sumArr = sumArr;
        this.valueArr = valueArr;
        this.pos = pos;
        this.start = start;
        this.end = end;
    }
    
    @Override
    public void run() {
        System.out.println("Starting " + pos);
        int localSum = 0;
        for(int i = start; i < end; i++) {
            localSum = localSum + valueArr[i];
        }
        sumArr[pos] = localSum;
        try {
            System.out.println("Service " + pos + "  Waiting for others Sum = " + sumArr[pos]);
            cb.await();
        } catch (InterruptedException ex) {
            System.out.println("Service one interrupted");
            Logger.getLogger(Service1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BrokenBarrierException ex) {
             System.out.println("Service one broken");
            Logger.getLogger(Service1.class.getName()).log(Level.SEVERE, null, ex);
        }
   //     System.out.println("Ending service 1");
    }
    
}

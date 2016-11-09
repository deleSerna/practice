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
public class CyclicBarrierSum {
    
    public static void main(String[] args) {
        
        int [] val =  { 1, 10, 5, 11, 12, 13, 16, 20, 22, 25, 30, 40 };
        int parties = 4;
        int size = val.length/parties;
        int [] sum = new int [parties];
        
        CyclicBarrier cb = new CyclicBarrier(parties + 1, new Runnable() {

            @Override
            public void run() {
                int s = 0;
                for(int i = 0; i < parties; i++) {
                    s = s + sum[i];
                }
                System.out.println("Total Sum" + s);
            }
        });
        int s = 0;
        int e = 0;
        for (int i = 0; i < parties; i++) {
            s = i * size;
           /* if(( i == parties - 1) && ())  {
                e = 
            }*/
            e = ( ((i + 1) * size) <=  val.length) ?  (i + 1) * size : e;
           Thread t = new Thread(new SumService(cb, sum, val, i, s, e));
           t.start();
        }
        try {
            cb.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(CyclicBarrierSum.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BrokenBarrierException ex) {
            Logger.getLogger(CyclicBarrierSum.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("ENDDDDDDDD");
    }
    
}

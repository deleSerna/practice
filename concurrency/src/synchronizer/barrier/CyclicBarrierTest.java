/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package synchronizer.barrier;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ntv
 */
public class CyclicBarrierTest {
    
    public static void main(String[] args) {
        CyclicBarrier  cb = new CyclicBarrier(3,
                            new Runnable() {

            @Override
            public void run() {
                System.out.println("Cyclic barrier finished");
            }
        });
        
        Thread th1 = new Thread(new Service1(cb));
        Thread th2 =  new Thread(new Service2(cb));
        System.out.println("Starting both service at "+ LocalTime.now());
        th1.start();
        th2.start();
        try {
            cb.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(CyclicBarrierTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BrokenBarrierException ex) {
            Logger.getLogger(CyclicBarrierTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Ending both service at "+ LocalTime.now());
        cb.reset();
       new Thread(new Service1(cb)).start();
       new Thread(new Service2(cb)).start();
        System.out.println("Starting both service for 2nd time at "+ LocalTime.now());
       try {
            cb.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(CyclicBarrierTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BrokenBarrierException ex) {
            Logger.getLogger(CyclicBarrierTest.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}

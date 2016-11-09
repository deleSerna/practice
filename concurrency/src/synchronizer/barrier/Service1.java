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
public class Service1 implements Runnable {
        CyclicBarrier cb;

    public Service1(CyclicBarrier c) {
        cb = c;
    }
        @Override
    public void run() {
        System.out.println("Starting service 1");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Service2.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                System.out.println("Service 2 Waiting for others");
                cb.await();
            } catch (InterruptedException ex) {
                Logger.getLogger(Service2.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BrokenBarrierException ex) {
                Logger.getLogger(Service2.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Ending service 2");
        
    }
}

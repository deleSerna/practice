/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package synchronizer.latch;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ntv
 */
public class LatchTest {
    public static void main(String[] args) {
        CountDownLatch cd = new CountDownLatch(0);
        Thread th1 = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("Thread1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(LatchTest.class.getName()).log(Level.SEVERE, null, ex);
                }
                cd.countDown();
            }
        });
                Thread th2 = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("Thread2");
                                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(LatchTest.class.getName()).log(Level.SEVERE, null, ex);
                }
                cd.countDown();
            }
        });
                th1.start();
                th2.start();
        try {
            cd.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(LatchTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}

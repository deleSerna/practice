/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semaphore;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ntv
 */
public class SemaTest {
        public static void main(String[] args) {
        Semaphore se = new Semaphore(1);
        Thread Th1 = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("1");
                                se.release();
            }
        });
        
                Thread Th2 = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("2");
                se.release();
            }
        });
                
                        Thread Th3 = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("3");
                                se.release();
            }
        });
                     
        try {
    
            Th1.start();
                        se.acquire();
            Th3.start();
                        se.acquire();
            Th2.start();
        } catch (InterruptedException ex) {
            Logger.getLogger(SemaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}

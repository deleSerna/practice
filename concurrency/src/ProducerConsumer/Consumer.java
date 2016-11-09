/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProducerConsumer;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ntv
 */
public class Consumer implements Runnable{
    ArrayList<Integer>sharedArray;
    int capcity;

    public Consumer(ArrayList<Integer>shareadArray, int capcity) {
        this.sharedArray = shareadArray;
        this.capcity = capcity;
    }

    
    
    @Override
    public void run() {
        try {
            consume(); //To change body of generated methods, choose Tools | Templates.
        } catch (InterruptedException ex) {
            Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void consume() throws InterruptedException {
        while (true) {  
        synchronized(sharedArray) {
            while(isEmpty()) {
                sharedArray.wait();
            }
        }
        
        synchronized(sharedArray) {
            System.out.println("Consuming item" + sharedArray.get(0));
            sharedArray.remove(0);
            sharedArray.notifyAll();
        }
            
        }
        
        
    }
    
    
    boolean isEmpty() {
        return sharedArray.size() == 0;
    }
    
}

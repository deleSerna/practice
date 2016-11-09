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
 *http://www.javamadesoeasy.com/2015/03/solve-consumer-producer-pattern-by.html
 * @author ntv
 */
public class Producer implements Runnable{
    ArrayList<Integer>sharedArray;
    int capcity;
    int i;
    public Producer(ArrayList<Integer>sharedArray, int capcity) {
        this.sharedArray = sharedArray;
        this.capcity = capcity;
    }
    
    public void run() {
        for (int j = 0; j < capcity + 10; j++) {
            produce(j);
        }
    }
    
    public void produce(int j) {
        synchronized(sharedArray) {
            while(isFull()) {
                try {
                    sharedArray.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            synchronized(sharedArray) {
                sharedArray.add(i);
                i++;
                sharedArray.notifyAll();
            }
            System.out.println("Produce"+ j);
            }
    }
    
    
    public boolean isFull() {
        return sharedArray.size() == capcity;
    }
    
}

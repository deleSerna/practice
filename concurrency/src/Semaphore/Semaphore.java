/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semaphore;

/**
 *
 * @author ntv
 */
public class Semaphore {
    int capacity;
    int count;
    public Semaphore(int capacity) {
        this.capacity = capacity;
        this.count = capacity;
    }
    
    public void acquire() throws InterruptedException {
        synchronized(this){
             while(count <=0)
                 wait();
             count--; 
        }
       
        
    }
    
    public void release() {
        synchronized(this){
            if (count < capacity)
                count++;
            notifyAll();
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProducerConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ntv
 */
public class ProducerConsumerUsingBlockQue {
    public static void main(String[] args) {
        int capacity = 5;
        BlockingQueue<Integer> bq = new ArrayBlockingQueue(capacity);
        Thread th1 = new Thread(new Producer1(bq, capacity));
        Thread th2 = new Thread(new Consumer1(bq, capacity));
        th1.start();
        th2.start();
    }
            
    
}

class Producer1  implements Runnable {
    BlockingQueue<Integer> bq;
    int capacity;
    public Producer1(BlockingQueue bq, int capacity) {
        this.bq = bq;
        this.capacity = capacity;
    }

    @Override
    public void run() {
        for (int j = 0; j < capacity ; j++) {
            try {
                produce(j);
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    void produce(int j) throws InterruptedException {
        bq.put(j);
        System.out.println("produced"+j);
    }
    
    
    
}


class Consumer1  implements Runnable {
    BlockingQueue<Integer> bq;
    int capacity;
    public Consumer1(BlockingQueue bq, int capacity) {
        this.bq = bq;
        this.capacity = capacity;
    }

    @Override
    public void run() {
        try {
            consume();
        } catch (InterruptedException ex) {
            Logger.getLogger(Consumer1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    void consume() throws InterruptedException {
          Integer a;
        while(true) {
           a = bq.take();
        System.out.println("consumed"+a); 
        }
 
    }
    
    
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProducerConsumer;

import java.util.ArrayList;

/**
 *
 * @author ntv
 */
public class TestProducerConsumer {
    public static void main(String[] args) {
        ArrayList<Integer> a  = new ArrayList<>();
        int capacity = 20;
        Thread t1  = new Thread(new Producer(a, capacity));
        Thread t2  = new Thread(new Consumer(a, capacity));
        t1.start();
        t2.start();
    }
    
}

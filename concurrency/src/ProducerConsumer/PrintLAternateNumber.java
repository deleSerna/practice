/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProducerConsumer;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ntv
 */
public class PrintLAternateNumber {
    public static void main(String[] args) {
        int [] num = {1,2,3,4,5,6};
        Printer p = new Printer();
        Thread t1 = new Thread(new Thread1(num,  p), "Thread1");
        Thread t2 = new Thread(new Thread2(num,  p), "Thread2");
        t1.start();
        t2.start();
    }
            
    
}

class Thread1 implements Runnable {
    int [] num;
    Printer p ;
    public Thread1(int[] num,  Printer p) {
        this.num = num;
        this.p = p;
    }
    
    public void run() {
        try {
            print();
        } catch (InterruptedException ex) {
            Logger.getLogger(Thread1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void print() throws InterruptedException {
        int i = 1;
        
            while(i < num.length) {
                synchronized(num) {
                    while (p.evenPrinted) {
                        num.wait();
                     }
                }   
                
                synchronized(num) {
                     p.printEven(Thread.currentThread().getName(), num[i]);
                     i= i + 2;
                     num.notifyAll();

                }
            }
    }
}


class Thread2 implements Runnable {
    int [] num;
    Printer p ;
    public Thread2(int[] num, Printer p) {
        this.num = num;
        this.p = p;
    }
    
    public void run() {
        try {
            print();
        } catch (InterruptedException ex) {
            Logger.getLogger(Thread2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void print() throws InterruptedException {
        int i = 0;
        
            while(i < num.length) {
                synchronized(num) {
                    while (!p.evenPrinted) {
                        num.wait();
                     }
                }    
                
                 synchronized(num) {
                     p.printOdd(Thread.currentThread().getName(), num[i]);
                     i = i + 2;
                     num.notifyAll();

                }
            }
    }
}

class Printer {
    boolean evenPrinted = true;
    void printEven(String threadName , int i) {
        System.out.println(threadName + "," + i);
        evenPrinted = true;
    }
    
    
        void printOdd(String threadName , int i) {
        System.out.println(threadName + "," + i);
        evenPrinted = false;
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

/**
 *
 * @author ntv
 */
class Node <T> {
    T val;
    Node next;
    Node(T val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListIm<T> {
    Node<T> head = null;
    Node<T> last = null;
    int size = 0; 
    
    boolean add(T val) {
        Node n = new Node(val); ;
        if(head == null) {
            head = n;
        } else {
            last.next = n;
        }
        last = n;
        size++;
        return true;
    }
    
    boolean contains(T val) {
        Node temp = head;
        while(temp != null) {
            if(temp.val == val)
                return true;
            else
                temp = temp.next;
        }
        return false;
    }
    
    boolean remove(Object o) {
        Node temp  = head;
        Node prev = null;
        while(temp != null) {
            if(temp.val.equals(o)) {
                if(temp == head) {
                    head = head.next;
                    
                } else {
                    prev.next = temp.next;
                    if(last == temp) 
                        last = prev;
                }
                size--;
                return true;
            }
            prev = temp;
            temp = temp.next;
        }
        return false;
    }
    
    
    
    int size() {
        return size;
    }
    
    void print() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

}

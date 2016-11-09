/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

import java.time.format.DateTimeFormatterBuilder;
import java.util.LinkedList;

/**
 *
 * @author ntv
 */
public class SplitList {
 

    
    public static void main(String[] args) {
     LinkedListIm<String> list = new LinkedListIm();
     list.add("a");
     list.add("b");
     list.add("c");
    // list.add(10);
    // System.out.println("size="+list.size());
     System.out.println(list.contains("c"));
     System.out.println(list.remove(-2));
     System.out.println(list.remove(1));
     //System.out.println("head="+list.head.next.val);
     //System.out.println("last="+list.last.val);
     list.print();
        //System.out.println("");
    }
    
    
    
}

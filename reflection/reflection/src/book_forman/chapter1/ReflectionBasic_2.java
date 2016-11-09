/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book_forman.chapter1;

/**
 *
 * @author ntv
 */
public class ReflectionBasic_2 {
    public static void main(String[] args) {
        int a = 2;
        int b[] ={1,2};
        System.out.println(b.getClass().getComponentType());
        System.out.println(Class.class.isInstance(Object.class));
        System.out.println(String.class.isInstance(Object.class));
    }
    
}

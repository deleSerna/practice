/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book_forman.chapter1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Properties;

/**
 *
 * @author ntv
 */

class Hello {
    public String printHello() {
        return "Hello";
    }
    
    public int printWorld(int world) {
          return world;
    }
    
    
    
}


public class Reflection$Basic_1 {
    void callReflectiveMethod(Class c) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method m = c.getMethod("printHello", null);
        Object a = m.invoke(new Hello(), null);
        System.out.println(a);
        m = c.getMethod("printWorld", int.class);
        Integer op = (Integer) m.invoke(new Hello(), 2);
        System.out.println(""+op.intValue());
    }
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Reflection$Basic_1 r = new Reflection$Basic_1();
        r.callReflectiveMethod(Hello.class);
    }
}

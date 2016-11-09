/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book_forman.chapter3;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;

/**
 *
 * @author ntv
 */
public class Constr {
    public static void main(String[] args) {
        try {
          
            Class cls = Class.forName("book_forman.chapter3.ForName");
            Constructor cr = cls.getConstructor(int.class);
            System.out.println("Name="+cr.getName() + "Modif=" + cr.getModifiers());
            ForName fn = (ForName) cr.newInstance(1);
            Arrays.asList(cls.getConstructors()).stream().forEach(System.out::println);
            int[] x = new int[5];
            System.out.println(""+x[2]);
            Array.newInstance(int.class, 5);
            Array.newInstance(String.class, new int[] {1,3,4});
            
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | 
                 IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(Constr.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}

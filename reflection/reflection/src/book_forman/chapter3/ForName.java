package book_forman.chapter3;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ntv
 */
public class ForName {

    public ForName( int a) {
    }
    private ForName() {
    }
    
    public static void main(String[] args) {
        String name = "java.lang.String";
        String arrayName = "[I";
        char [] a = new char[] {'1','2'};
        String arrayName2 = "[Ljava.lang.String;";
        
        try {
            Class c1 = Class.forName(name);
            Class c2 = Class.forName(arrayName);
            Class c3 = Class.forName(int[].class.getName());
            Class c4 = Class.forName(arrayName2);
            try {
                //     Class c5 = Class.forName(int.class.getName());
                String m =  (String) c1.newInstance();
            } catch (InstantiationException ex) {
                Logger.getLogger(ForName.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ForName.class.getName()).log(Level.SEVERE, null, ex);
            }
           } catch (ClassNotFoundException ex) {
            Logger.getLogger(ForName.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}

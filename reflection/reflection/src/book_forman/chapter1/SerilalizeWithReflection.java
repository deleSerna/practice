/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book_forman.chapter1;

import common.Person;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ntv
 */
public class SerilalizeWithReflection {
 
    public static void main(String[] args) {
        List<Field> fieldList = new ArrayList();
        try {
            Double d = -1.2;
            Class clz = Class.forName("common.Person");
            Person p = (Person) clz.newInstance();
            Arrays.stream(clz.getDeclaredFields()).forEach(fieldList::add);
            fieldList.stream().forEach(x -> System.out.println("Class= "+x.getClass() + " Name= " + x.getName() +" Modifier= "+x.getModifiers() ));
            //Arrays.stream(clz.getDeclaredFields()).toArray(Field[]::new);
            System.out.println(""+clz.getDeclaredField("asd").get(p));
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchFieldException | SecurityException ex) {
            Logger.getLogger(SerilalizeWithReflection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.indhio.reflection.reflection5;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rlinden
 */
public class Main {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Class c=Exemplo2.class;
        try {
            Class cls;
            cls = Class.forName("java.lang.String");
            Object arr = Array.newInstance (cls, 10);
            Method m = c.getDeclaredMethod("metodo1", new Class[]{int.class});
            m.setAccessible(true);
            m.invoke(new Exemplo2(), 1);
            m=c.getDeclaredMethod("metodo1");
            m.invoke(new Exemplo2());
            System.out.println("Mostrando a hierarquia de classes:");
            Class clasCorrente=cls;
            while(clasCorrente!=null) {
                System.out.println(clasCorrente.getName());
                clasCorrente=clasCorrente.getSuperclass();
            }
        } catch (ClassNotFoundException ex) {
        } catch (IllegalAccessException ex) {
        } catch (IllegalArgumentException ex) {
        } catch (InvocationTargetException ex) {
        } catch (NoSuchMethodException ex) {            
        } catch (SecurityException ex) {            
        }
    }
}

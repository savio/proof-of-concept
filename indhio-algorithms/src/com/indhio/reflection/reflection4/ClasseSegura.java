/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.indhio.reflection.reflection4;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import sun.reflect.Reflection;

/**
 *
 * @author rlinden
 */
public class ClasseSegura {
    public void metodoSeguro() {
        Class c=Reflection.getCallerClass(2);        
        if (c.getPackage().equals(this.getClass().getPackage())) {
           System.out.println("Executando a parte segura");
        } else {
           System.out.println("Executando apenas a parte comum a todos");
        }        
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.indhio.reflection.reflection1;

import java.util.ArrayList;
import java.util.List;
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
        if (args.length>0) {
            try {
                Class c = Class.forName(args[0]);
                if (c.isAssignableFrom(List.class)) {
                    List minhaLista = (List) c.newInstance();
                    System.out.println("A lista é da classe "+minhaLista.getClass());
                } else {
                    System.out.println("A classe "+c.getName()+" não implementa a interface lista.");
                }
            } catch (ClassNotFoundException ex) {                
            } catch (InstantiationException ex) {
            } catch (IllegalAccessException ex) {
            }
        } else {
            System.out.println("Você esqueceu de passar a classe como parâmetro.");
        }
    }

}

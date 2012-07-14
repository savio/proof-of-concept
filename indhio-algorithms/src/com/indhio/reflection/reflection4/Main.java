/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.indhio.reflection.reflection4;

import com.indhio.reflection.reflection4.pacoteExterno.ClasseExterna;

/**
 *
 * @author rlinden
 */
public class Main {

    public void chamador() {
       ClasseSegura cs=new ClasseSegura();
       cs.metodoSeguro();
       ClasseExterna ce=new ClasseExterna();
       ce.chamaClasseSegura();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Main m=new Main();
       m.chamador();
    }

}

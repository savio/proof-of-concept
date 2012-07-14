/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.indhio.reflection.reflection4.pacoteExterno;

import com.indhio.reflection.reflection4.ClasseSegura;

/**
 *
 * @author rlinden
 */
public class ClasseExterna {
    public void chamaClasseSegura() {
        ClasseSegura cs=new ClasseSegura();
        cs.metodoSeguro();
    }
}

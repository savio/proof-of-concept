/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.indhio.reflection.reflection3;

/**
 *
 * @author rlinden
 */
public class Exemplo {

    private int valor1, valor2;

    public Exemplo() {
        valor1=-1;
        valor2=-1;
    }

    public Exemplo(int v1) {
        this();
        valor1=v1;
    }

    public Exemplo(int v1, int v2) {
        this(v1);
        valor2=v2;
    }

    public String toString() {
        return("valor1="+valor1+" e valor2="+valor2);
    }

}

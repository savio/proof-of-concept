/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.indhio.reflection.reflection2;

/**
 *
 * @author rlinden
 */
public class DaoOracle implements Dao {
    public boolean conecta() {
        return(true);
    }

    public boolean create(Object o) {
        return (true);
    }

    public boolean update(Object o) {
        return (true);
    }

    public boolean delete(Object o)  {
        return (true);
    }

    public Object retrieve(String chave) {
        return(new Object());
    }
}

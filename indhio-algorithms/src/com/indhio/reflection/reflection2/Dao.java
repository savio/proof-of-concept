/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.indhio.reflection.reflection2;

/**
 *
 * @author rlinden
 */
public interface Dao {
    public boolean conecta();
    public boolean create(Object o);
    public boolean update(Object o);
    public boolean delete(Object o);
    public Object retrieve(String chave);
}

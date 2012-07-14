/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.indhio.reflection.reflection2;

/**
 *
 * @author rlinden
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Dao meuDao;
        if (args.length>0) {
            try {
                Class c = Class.forName(args[0]);
                meuDao= (Dao) c.newInstance();
                System.out.println("O DAO é da classe "+meuDao.getClass());
            } catch (ClassNotFoundException ex) {
            } catch (InstantiationException ex) {
            } catch (IllegalAccessException ex) {
            }
        } else {
            System.out.println("Você esqueceu de passar a classe como parâmetro.");
        }
    }

}

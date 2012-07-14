/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.indhio.reflection.reflection3;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author rlinden
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Class minhaClasse=Exemplo.class;
        Class[] tiposParametros=new Class[]{int.class};
        Object[] parametrosReais=new Object[]{5};
        try {
           Constructor meuConstrutor=minhaClasse.getConstructor(tiposParametros);
           meuConstrutor.setAccessible(true);
           Exemplo e=(Exemplo) meuConstrutor.newInstance(parametrosReais);
           System.out.println("Saida= "+e.toString());
        } catch (NoSuchMethodException ex) {
        } catch (InvocationTargetException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        }
        Exemplo exemplo1=new Exemplo(19,1);
        Exemplo exemplo2=new Exemplo(2,3);
        ReflectionComparator comp=new ReflectionComparator("valor1");
        System.out.println("Resultado da comparação:"+comp.compare(exemplo1, exemplo2));
        comp.setComparisonField("valor2");
        System.out.println("Resultado da comparação:"+comp.compare(exemplo1, exemplo2));
        exemplo2=new Exemplo(19,0);
        System.out.println("Resultado da comparação:"+comp.compare(exemplo1, exemplo2));
        comp.setComparisonField("valor1");
        System.out.println("Resultado da comparação:"+comp.compare(exemplo1, exemplo2));
    }

}

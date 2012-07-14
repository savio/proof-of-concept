/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.indhio.reflection.reflection3;

import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rlinden
 */
public class ReflectionComparator<E> implements Comparator<E> {

    private String comparisonField;
    private int order;
    public final static int C_ASCENDING = 1;
    public final static int C_DESCENDING = -1;
    public final static int C_ERRO_CLASSES_NAO_COMPARAVEIS=-1000;
    public final static int C_ERRO_CAMPO_INEXISTENTE=-1001;
    public final static int C_ERRO_CAMPO_INACESSIVEL=-1002;

    public ReflectionComparator(String comparisonField, int order) {
        super();
        this.setComparisonField(comparisonField);
        this.setOrder(order);
    }

    public ReflectionComparator(String comparisonField) {
        this(comparisonField,C_ASCENDING);
    }

    private ReflectionComparator() {}

    @Override
    public int compare(E obj1, E obj2)  {
        if ((obj1==null)&&(obj2==null)) {
            return(0);
        }
        if (((obj1==null)&&(obj2!=null))||
            ((obj1!=null)&&(obj2==null))){
            return(ReflectionComparator.C_ERRO_CLASSES_NAO_COMPARAVEIS);
        }
        Class classeComp=obj1.getClass();        
        Field campoComp=null;        
        try {
            campoComp = classeComp.getDeclaredField(comparisonField);            
        } catch (NoSuchFieldException ex) {
            return(ReflectionComparator.C_ERRO_CAMPO_INEXISTENTE);
        } catch (SecurityException ex) {
            return(ReflectionComparator.C_ERRO_CAMPO_INACESSIVEL);
        }
        campoComp.setAccessible(true);
        Object value1=null, value2=null;
        try {
            value1 = campoComp.get(obj1);
            value2 = campoComp.get(obj2);
            Class auxClasse=value1.getClass();                        
        } catch (IllegalArgumentException ex) {
        } catch (IllegalAccessException ex) {
            return(ReflectionComparator.C_ERRO_CAMPO_INACESSIVEL);
        }        
        if (value1 == null) {
            if (value2 == null) {
                return 0;
            } else {
                return getOrder() * -1;
            }
        } else if (value2 == null) {
            return getOrder();
        } else if (value1 instanceof Comparable) {
            return getOrder() * ((Comparable) value1).compareTo(value2);
        } else {
            return getOrder() * value1.toString().compareTo(value2.toString());
        }

    }

    /**
     * @return the comparisonField
     */
    public String getComparisonField() {
        return comparisonField;
    }

    /**
     * @param comparisonField the comparisonField to set
     */
    public void setComparisonField(String comparisonField) {
        this.comparisonField = comparisonField;
    }

    /**
     * @return the order
     */
    public int getOrder() {
        return order;
    }

    /**
     * @param order the order to set
     */
    public void setOrder(int order) {
        if (order<0) {
            this.order = C_DESCENDING;
        } else {
            this.order=C_ASCENDING;
        }
    }
}

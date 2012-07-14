package com.indhio;

import java.util.ArrayList;

public class ArrayTeste {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> lista = new ArrayList<Integer>();
		lista.add(new Integer(1));
		lista.add(new Integer(325));
		lista.add(new Integer(27));
		lista.add(new Integer(7));
		lista.add(new Integer(1000));
		
		System.out.println(lista.contains(new Integer(10)));
		
		Integer [] recursos = new Integer[2];
		recursos[0] = new Integer(27);
		recursos[1] = new Integer(10);
		
		
	}

}

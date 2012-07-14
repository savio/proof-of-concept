package com.indhio;

import java.util.ArrayList;

public class Arraysss {
	
	public static void main(String[] args) {
		ArrayList<Integer> lista = new ArrayList<Integer>();
		lista.add(new Integer(10));
		lista.add(new Integer(100));
		lista.add(new Integer(1000));
		Integer [] array = new Integer[lista.size()];
		if(array != null) {
			for(int i = 0; i < lista.size(); i++) {
				array[i] = lista.get(i);
				System.out.println(" >>>> " + array[i]);
			}
		}
	}

}

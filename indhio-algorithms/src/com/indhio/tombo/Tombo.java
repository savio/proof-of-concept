package com.indhio.tombo;

public class Tombo {

	public static void main(String[] args) {

		String idTombo = "MVD00000";
		Integer id = 287;
		int valor1 = id.intValue();
		int count = 1;
		while (valor1 / 10 > 0) {
			count++;
			valor1 = valor1 / 10;
		}
		idTombo = idTombo.substring(0, idTombo.length() - count) + id;
		System.out.println("idTombo >>> " + idTombo);

	}

}

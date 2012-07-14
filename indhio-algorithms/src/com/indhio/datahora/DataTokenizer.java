package com.indhio.datahora;

import java.util.StringTokenizer;

public class DataTokenizer {

	public static void dataTokenizer() {

		int dia = 0;
		int mes = 0;
		int ano = 0;

		String data = "10/12/2002";
		StringTokenizer st = new StringTokenizer(data, "/");
		System.out.println("total > " + st.countTokens());

		int contador = 1;
		if (st.countTokens() == 3) {
			// dia / mes / ano
			while (st.hasMoreTokens()) {
				if (contador == 1) {
					dia = Integer.parseInt(st.nextToken());
				} else if (contador == 2) {
					mes = Integer.parseInt(st.nextToken());
				} else if (contador == 3) {
					ano = Integer.parseInt(st.nextToken());
				}
				contador++;
			}
		} else if (st.countTokens() == 2) {
			// mes / ano
			while (st.hasMoreTokens()) {
				if (contador == 1) {
					mes = Integer.parseInt(st.nextToken());
				} else if (contador == 2) {
					ano = Integer.parseInt(st.nextToken());
				}
				contador++;
			}
		} else {
			// somente ano
			ano = Integer.parseInt(st.nextToken());
		}

		System.out.println(">>>> " + dia + " / " + mes + " / " + ano);

	}

	public static void main(String[] args) {
		dataTokenizer();
	}

}

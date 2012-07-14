package com.indhio.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class PercentualConcluido {

	public static void main(String[] args) {

		Integer percentual = 99;

		ArrayList<Integer> percentuaisConcluidos = new ArrayList<Integer>();
		Integer temp = 0;
		// percentuaisConcluidos.add(temp);
		for (int i = 0; i < (100 / 10); i++) {
			temp = temp + 10;
			if (temp.intValue() != 100) {
				percentuaisConcluidos.add(temp);
			}
		}

		Integer[] array = new Integer[percentuaisConcluidos.size()];
		for (int i = 0; i < percentuaisConcluidos.size(); i++) {
			array[i] = percentuaisConcluidos.get(i);
			System.out.println(">>> " + array[i]);
		}

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (Integer i : array) {
			map.put(i, percentual - i);
		}

		// System.out.println(map);

		Integer menorValor = 100;
		Integer novoPerc = 0;

		Set<Integer> chaves = map.keySet();
		Iterator<Integer> it = chaves.iterator();
		while (it.hasNext()) {
			Integer chave = (Integer) it.next();
			Integer valor = Math.abs((Integer) map.get(chave));
			System.out.println("chave >> " + chave + " - valor >> " + valor);

			if (valor < menorValor) {
				menorValor = valor;
				novoPerc = chave;
			}

		}

		System.out.println("--------");
		System.out.println(menorValor);
		System.out.println(novoPerc);

	}

	public static void main1(String[] args) {

		Integer percentual = 73;

		Integer[] array = new Integer[] { 0, 20, 40, 60, 80, 100 };

		Integer proximoDe = 0;
		for (Integer i : array) {
			if (percentual == i) {
				proximoDe = i;
				break;
			}

			Integer temp = percentual - i;
			temp = Math.abs(temp);
			System.out.println(temp);
			if (!(temp.intValue() <= 0)) {
				proximoDe = i;
			}
		}
		System.out.println("--------");
		System.out.println(proximoDe);
	}

	public static void main2(String[] args) {

		Integer perc = 83;

		ArrayList<Integer> percentuaisConcluidos = new ArrayList<Integer>();
		Integer graduacao = 25;
		Integer valor = 0;
		percentuaisConcluidos.add(valor);
		for (int i = 0; i < (100 / graduacao); i++) {
			valor = valor + graduacao;
			percentuaisConcluidos.add(valor);
		}

		for (Integer i : percentuaisConcluidos) {
			System.out.println(i);
		}
		System.out.println();
		System.out.println(perc);

	}

}

package com.indhio.megasena;

import java.util.HashSet;
import java.util.Set;

public class MegaSena {

	private final int TOTAL_CARTELAS = 20;
	private final int TOTAL_JOGOS_POR_CARTELA = 3;
	private final int TOTAL_NUMEROS_POR_JOGO = 6;

	public void jogar() {
		try {

			int totalJogos = TOTAL_CARTELAS * TOTAL_JOGOS_POR_CARTELA;
			for (int i = 0; i < totalJogos; i++) {

				Jogo jogo = new Jogo();
				jogo.setId(new Long(i + 1));
				jogo.setJogos(jogos());
				verJogo(jogo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Set<Long> jogos() {
		try {
			Set<Long> jogos = new HashSet<Long>();
			for (int j = 0; j < TOTAL_NUMEROS_POR_JOGO; j++) {
				jogos.add(sorteio(jogos));
			}
			
			return jogos;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Long sorteio(Set<Long> jogos) {
		try {
			Long numero = Long.valueOf((int) ((int) 1 + (Math.random() * 60)));
			//System.out.println("tem numero repetido > " + jogos.contains(numero));
			if (jogos.contains(numero)) {
				numero = sorteio(jogos);
			}
			return new Long(numero);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0L;
	}

	public void verJogo(Jogo jogo) {
		StringBuilder sb = new StringBuilder();
		sb.append("ID: " + jogo.getId() + " \t\t");

		for (Long numero : jogo.getJogos()) {
			sb.append(" | " + numero + " ");
		}
		System.out.println(sb.toString());
	}

}

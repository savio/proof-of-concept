package com.indhio.megasena;

import java.util.HashSet;
import java.util.Set;

public class Jogo {

	private Long id;
	private Set<Long> jogos = new HashSet<Long>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Long> getJogos() {
		return jogos;
	}

	public void setJogos(Set<Long> jogos) {
		this.jogos = jogos;
	}

}

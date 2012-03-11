package com.lilnkdata.pregao.pc.pojo;

public class Lote {

	private LoteId loteId;
	private String situacao;
	private String tempo;
	private String meuLance;
	private String melhorLance;

	public Lote(LoteId loteId, String situacao, String tempo, String meuLance, String melhorLance) {
		super();
		this.loteId = loteId;
		this.situacao = situacao;
		this.tempo = tempo;
		this.meuLance = meuLance;
		this.melhorLance = melhorLance;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getTempo() {
		return tempo;
	}

	public void setTempo(String tempo) {
		this.tempo = tempo;
	}

	public String getMeuLance() {
		return meuLance;
	}

	public void setMeuLance(String meuLance) {
		this.meuLance = meuLance;
	}

	public String getMelhorLance() {
		return melhorLance;
	}

	public void setMelhorLance(String melhorLance) {
		this.melhorLance = melhorLance;
	}

	public LoteId getLoteId() {
		return loteId;
	}

	public void setLoteId(LoteId loteId) {
		this.loteId = loteId;
	}

}

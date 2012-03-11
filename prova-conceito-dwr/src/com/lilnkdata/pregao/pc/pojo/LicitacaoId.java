package com.lilnkdata.pregao.pc.pojo;

import java.io.Serializable;

public class LicitacaoId implements Serializable, Cloneable {

	private static final long serialVersionUID = 656313020104212898L;

	private String cdLicitacao;
	private String orgao;
	private String ug;

	public LicitacaoId() {
	}

	public LicitacaoId(String orgao, String ug, String cdLicitacao) {
		this.orgao = orgao;
		this.ug = ug;
		this.cdLicitacao = cdLicitacao;
	}

	public String getCdLicitacao() {
		return cdLicitacao;
	}

	public void setCdLicitacao(String cdLicitacao) {
		this.cdLicitacao = cdLicitacao;
	}

	public String getUg() {
		return ug;
	}

	public void setUg(String ug) {
		this.ug = ug;
	}

	public String getOrgao() {
		return orgao;
	}

	public void setOrgao(String orgao) {
		this.orgao = orgao;
	}

	public boolean equals(Object object) {
		if (object instanceof LicitacaoId) {
			LicitacaoId other = (LicitacaoId) object;
			return cdLicitacao.equals(other.getCdLicitacao()) && ug.equals(other.getUg()) && orgao.equals(other.getOrgao());
		}

		return false;
	}

	@Override
	public int hashCode() {
		return (orgao + ug + cdLicitacao).hashCode();
	}

	@Override
	public String toString() {
		// return "Lic(" + hashCode() + ")[orgao=" + orgao + ",ug=" + ug + ",cdLic=" + cdLicitacao + "]";
		return getOrgao() + "/" + getUg() + "/" + getCdLicitacao();
	}

	@Override
	public LicitacaoId clone() {
		try {
			return (LicitacaoId) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.getMessage());
		}
	}
}

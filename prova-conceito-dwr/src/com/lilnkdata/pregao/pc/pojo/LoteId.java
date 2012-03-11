package com.lilnkdata.pregao.pc.pojo;

import java.io.Serializable;

public class LoteId implements Serializable, Cloneable {

	private static final long serialVersionUID = 6673883598817903669L;

	public LicitacaoId licitacaoId;
	public Long sequencial;

	public LoteId() {
	}

	public LoteId(String orgao, String ug, String cdLicitacao, Long sequencial) {
		this.licitacaoId = new LicitacaoId(orgao, ug, cdLicitacao);
		this.sequencial = sequencial;
	}

	public LicitacaoId getLicitacaoId() {
		return licitacaoId;
	}

	public void setLicitacaoId(LicitacaoId licitacaoId) {
		this.licitacaoId = licitacaoId;
	}

	public Long getSequencial() {
		return sequencial;
	}

	public void setSequencial(Long sequencial) {
		this.sequencial = sequencial;
	}

	public boolean equals(Object object) {
		if (object instanceof LoteId) {
			LoteId other = (LoteId) object;
			if (sequencial != null && other.sequencial != null) {
				return sequencial.equals(other.sequencial) && licitacaoId.equals(other.licitacaoId);
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return (licitacaoId.toString() + sequencial).hashCode();
	}

	@Override
	public String toString() {
		return licitacaoId.toString() + "/" + getSequencial();
	}

	@Override
	public Object clone() {
		LoteId ret = null;
		try {
			ret = (LoteId) super.clone();
			ret.setLicitacaoId((LicitacaoId) licitacaoId.clone());
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.getMessage());
		}

		return ret;
	}

}

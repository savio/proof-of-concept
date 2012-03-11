package com.lilnkdata.pregao.pc.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SituacaoLote {

	public static final Integer DISPUTA_NAO_INICIADA = 1;
	public static final Integer DISPUTA_EM_ANDAMENTO = 2;
	//public static final Integer DISPUTA_ENCERRADA = 3;
	public static final Integer NEGOCIACAO = 4;
	public static final Integer ENVIO_DOCUMENTACAO = 6;
	public static final Integer NEGOCIACAO_ENCERRADA = 7;
	public static final Integer INTERPOSICAO_RECURSO = 8;
	public static final Integer INTERPOSICAO_RECURSO_ENCERRADO = 9;	
	public static final Integer ADJUDICADO = 10;
	public static final Integer HOMOLOGADA = 11;
	public static final Integer REVOGADO = 12;
	public static final Integer DESERTO = 13;
	public static final Integer ANULADA = 14;
	public static final Integer FRACASSADO = 15;
	public static final Integer SUSPENSO = 16;
	public static final Integer AGUARDANDO_PRAZO_RECURSAL = 17;
	public static final Integer ENVIO_DOCUMENTACAO_ENCERRADO = 18;
	
	private static List<SituacaoLote> lista;
	static {
		lista = new ArrayList<SituacaoLote>();
		lista.add(new SituacaoLote(DISPUTA_NAO_INICIADA));
		lista.add(new SituacaoLote(DISPUTA_EM_ANDAMENTO));
		//lista.add(new SituacaoLote(DISPUTA_ENCERRADA));
		lista.add(new SituacaoLote(NEGOCIACAO));
		lista.add(new SituacaoLote(ENVIO_DOCUMENTACAO));
		lista.add(new SituacaoLote(ENVIO_DOCUMENTACAO_ENCERRADO));
		lista.add(new SituacaoLote(AGUARDANDO_PRAZO_RECURSAL));
		lista.add(new SituacaoLote(INTERPOSICAO_RECURSO));
		lista.add(new SituacaoLote(ADJUDICADO));
		lista.add(new SituacaoLote(HOMOLOGADA));
		lista.add(new SituacaoLote(REVOGADO));
		lista.add(new SituacaoLote(DESERTO));
		lista.add(new SituacaoLote(ANULADA));
		lista.add(new SituacaoLote(FRACASSADO));
		lista.add(new SituacaoLote(SUSPENSO));
	}
	
	private static Map<Integer, String> mapa;
	static {
		mapa = new TreeMap<Integer, String>();
		mapa.put(DISPUTA_NAO_INICIADA, encode("Disputa não iniciada"));
		mapa.put(DISPUTA_EM_ANDAMENTO, encode("Disputa em andamento"));
		//mapa.put(DISPUTA_ENCERRADA, "Disputa encerrada");
		mapa.put(NEGOCIACAO, encode("Em negociação"));
		mapa.put(ENVIO_DOCUMENTACAO, encode("Envio de documentação"));
		mapa.put(ENVIO_DOCUMENTACAO_ENCERRADO, encode("Envio de documentação encerrado"));
		mapa.put(NEGOCIACAO_ENCERRADA, encode("Negociação encerrada"));
		mapa.put(INTERPOSICAO_RECURSO, encode("Em fase de interposição de recurso"));
		mapa.put(INTERPOSICAO_RECURSO_ENCERRADO, encode("Interposição de recurso encerrado"));
		mapa.put(ADJUDICADO, encode("Adjudicado"));
		mapa.put(HOMOLOGADA, encode("Homologado"));
		mapa.put(REVOGADO, encode("Revogado"));
		mapa.put(DESERTO, encode("Deserto"));
		mapa.put(ANULADA, encode("Anulada"));
		mapa.put(FRACASSADO, encode("Fracassado"));
		mapa.put(SUSPENSO, encode("Disputa suspensa"));
		mapa.put(AGUARDANDO_PRAZO_RECURSAL, encode("Aguardando prazo recursal"));
	}
	
	private static String encode(String text) {
		//try {
			return text; //new String(text.getBytes(), "ISO-8859-1");
		//} catch (UnsupportedEncodingException e) {
		//	return text;
		//}
	}
	
	private Integer codigo;
	
	public SituacaoLote() {}
	
	public SituacaoLote(Integer codigo) {
		this.codigo = codigo;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public String getDescricao() {
		if (this.codigo == null) {
			return mapa.get(DISPUTA_NAO_INICIADA);
		}
		return mapa.get(this.codigo);
	}
	
	public static List<SituacaoLote> getSituacoesLote() {
		return lista;
	}
	
	public static Map<Integer, String> getMapaSituacoes() {
		return mapa;
	}
	
	public static String obterDescricaoSituacao(Integer situacao) {
		if (situacao != null) {
			return mapa.get(situacao);
		}
		return mapa.get(DISPUTA_NAO_INICIADA);
	}
	
}

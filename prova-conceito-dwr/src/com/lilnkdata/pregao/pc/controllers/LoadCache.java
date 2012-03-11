package com.lilnkdata.pregao.pc.controllers;

import java.io.Serializable;

import org.apache.log4j.Logger;

import com.lilnkdata.pregao.pc.ajax.SalaDisputaAjax;
import com.lilnkdata.pregao.pc.pojo.Lote;
import com.lilnkdata.pregao.pc.pojo.LoteId;
import com.lilnkdata.pregao.pc.pojo.SituacaoLote;

public class LoadCache implements Serializable {

	private static final long serialVersionUID = -4781209617244799893L;

	private static org.apache.log4j.Logger log = Logger.getLogger(SalaDisputaAjax.class);

	public static LoadCache instance;

	public static LoadCache getInstance() {
		if (instance == null) {
			instance = new LoadCache();
		}
		return instance;
	}
	
	public LoadCache() {
		LoteId loteId3 = new LoteId("001", "200100", "2007000846", 3L);
		Lote lote3 = new Lote(loteId3, SituacaoLote.obterDescricaoSituacao(1), "0", "1000", "900");

		LoteId loteId2 = new LoteId("001", "200100", "2007000846", 2L);
		Lote lote2 = new Lote(loteId2, SituacaoLote.obterDescricaoSituacao(1), "0", "1000", "900");

		LoteId loteId1 = new LoteId("001", "200100", "2007000846", 1L);
		Lote lote1 = new Lote(loteId1, SituacaoLote.obterDescricaoSituacao(1), "0", "1000", "900");

		Cache cache = Cache.getInstance();
		cache.registerNewLote(lote1);
		cache.registerNewLote(lote2);
		cache.registerNewLote(lote3);

		cache.addMessage(loteId1, "Mensgem de carga do lote 1");
		cache.addMessage(loteId2, "Mensgem de carga do lote 2");
		cache.addMessage(loteId3, "Mensgem de carga do lote 3");

		log.info("Carga incial lotes: " + cache.getAllLote());
		log.info("Carga incial lotes: " + cache.getAllMensagens());
		
	}

}

package com.lilnkdata.pregao.pc.controllers;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;

import com.lilnkdata.pregao.pc.pojo.Lote;
import com.lilnkdata.pregao.pc.pojo.LoteId;
import com.lilnkdata.pregao.pc.pojo.Message;
import com.lilnkdata.pregao.pc.pojo.SituacaoLote;

public class Cache implements Serializable {

	private static final long serialVersionUID = -5395927454448302501L;

	private static Cache instance;

	public static Cache getInstance() {
		if (instance == null) {
			instance = new Cache();
		}
		return instance;
	}

	private HashMap<LoteId, Lote> lotes = new HashMap<LoteId, Lote>();
	private HashMap<LoteId, LinkedList<Message>> mensagens = new HashMap<LoteId, LinkedList<Message>>();

	public HashMap<LoteId, Lote> getAllLote() {
		return lotes;
	}

	public HashMap<LoteId, LinkedList<Message>> getAllMensagens() {
		return mensagens;
	}

	public Lote getLote(LoteId loteId) {
		return lotes.get(loteId);
	}

	public LinkedList<Message> getMensagensLote(LoteId loteId) {
		return mensagens.get(loteId);
	}

	public void registerNewLote(Lote lote) {
		synchronized (lotes) {
			LoteId loteId = lote.getLoteId();
			if (!lotes.containsKey(lote.getLoteId())) {
				lotes.put(loteId, lote);
			}
		}
	}

	public void addMessage(LoteId loteId, String messsage) {
		synchronized (mensagens) {
			if (!mensagens.containsKey(loteId)) {
				LinkedList<Message> msgs = new LinkedList<Message>();
				mensagens.put(loteId, msgs);
				addMessage(loteId, messsage);
			} else {
				mensagens.get(loteId).addLast(new Message(messsage));
			}
		}
	}

	public void cleanAll() {
		synchronized (lotes) {
			lotes.clear();
		}
		synchronized (mensagens) {
			mensagens.clear();
		}
	}

	public Lote getLoteIdByStr(String loteIdStr) {
		Lote lote = null;
		synchronized (lotes) {
			for (Lote lt : lotes.values()) {
				if (loteIdStr.equals(lt.getLoteId().toString())) {
					lote = lt;
					break;
				}
			}
		}
		return lote;
	}
	
	public void changeSituacao(String loteIdStr, Integer intSituacao) {
		Lote lote = getLoteIdByStr(loteIdStr);
		lote.setSituacao(SituacaoLote.obterDescricaoSituacao(intSituacao));
	}

}

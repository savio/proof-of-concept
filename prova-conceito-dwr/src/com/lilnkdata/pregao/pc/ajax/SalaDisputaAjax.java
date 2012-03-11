package com.lilnkdata.pregao.pc.ajax;

import java.util.LinkedList;
import java.util.List;

import org.directwebremoting.Browser;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.ScriptSessionFilter;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.ui.dwr.Util;

import com.lilnkdata.pregao.pc.controllers.Cache;
import com.lilnkdata.pregao.pc.controllers.LoadCache;
import com.lilnkdata.pregao.pc.pojo.Lote;
import com.lilnkdata.pregao.pc.pojo.LoteId;
import com.lilnkdata.pregao.pc.pojo.Message;

public class SalaDisputaAjax {

	public void execute(String loteIdStr) {
		LoadCache.getInstance(); // Carga Inicial
		WebContext web = WebContextFactory.get();
		ScriptSession sess = web.getScriptSession();
		sess.setAttribute("loteId", loteIdStr);
		updateScreen(loteIdStr);
	}

	public void addMessage(String loteIdStr, String text) {
		Cache cache = Cache.getInstance();
		Lote lote = cache.getLoteIdByStr(loteIdStr);
		LoteId loteId = lote.getLoteId();
		cache.addMessage(loteId, text);
		updateScreen(loteIdStr);
	}

	public void changeSituacao(String loteIdStr, Integer intSituacao) {
		Cache cache = Cache.getInstance();
		cache.changeSituacao(loteIdStr, intSituacao);
		updateScreen(loteIdStr);
	}
	
	private void updateScreen(String loteIdStr) {
		Cache cache = Cache.getInstance();
		Lote lote = cache.getLoteIdByStr(loteIdStr);
		updateScreen(cache, lote.getLoteId());
	}

	private void updateScreen(Cache cache, LoteId loteId) {
		Lote lote = cache.getLote(loteId);
		LinkedList<Message> messages = cache.getMensagensLote(loteId);
		waiit(lote, messages);
	}

	private void waiit(final Lote lote, final List<Message> messages) {
		Browser.withCurrentPageFiltered(scriptSessionFilter(lote.getLoteId().toString()), new Runnable() {
			public void run() {

				/** chat */
				Util.removeAllOptions("chatlog");
				Util.addOptions("chatlog", messages, "text");

				/** situacao | meu lance | melhor lance */
				Util.setValue("lt_situacao", lote.getSituacao());
				Util.setValue("lt_meuLance", lote.getMeuLance());
				Util.setValue("lt_melhorLance", lote.getMelhorLance());

			}
		});

	}

	private ScriptSessionFilter scriptSessionFilter(final String loteIdStr) {
		return new ScriptSessionFilter() {
			@Override
			public boolean match(ScriptSession ss) {
				Object check = ss.getAttribute("loteId");
				return check != null && check.equals(loteIdStr);
			}
		};
	}

}
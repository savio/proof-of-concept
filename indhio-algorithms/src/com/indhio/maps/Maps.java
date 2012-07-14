package com.indhio.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Maps {

	private static Map<String, Object> sessionsLogins = new HashMap<String, Object>();

	public static void main(String[] args) {
		
		Integer idEmpresa = 1;

		Map<String, Object> sessao1 = new HashMap<String, Object>();
		sessao1.put("id", 11111);
		sessao1.put("session", "9893892823849");
		sessao1.put("login", "indhio");
		sessao1.put("empresa", 1);
		sessionsLogins.put("indhio", sessao1);

		Map<String, Object> sessao2 = new HashMap<String, Object>();
		sessao2.put("id", 222222);
		sessao2.put("session", "989389asdf334");
		sessao2.put("login", "dinhenny");
		sessao2.put("empresa", 3);
		sessionsLogins.put("dinhenny", sessao2);
		
		Map<String, Object> sessao3 = new HashMap<String, Object>();
		sessao3.put("id", 33333333);
		sessao3.put("session", "9834349389asdf334");
		sessao3.put("login", "alguem");
		sessao3.put("empresa", 2);
		sessionsLogins.put("alguem", sessao3);

		int totalEmpresas = 0;
		
		Set<String> logins = sessionsLogins.keySet();
		for (String s : logins) {
			Map<String, Object> map = (Map<String, Object>) sessionsLogins.get(s);
			Integer empresa = (Integer) map.get("empresa");
			if(empresa.equals(idEmpresa)) {
				totalEmpresas++;
			}
		}
		
		System.out.println("TOTAL POR EMPRESA = " + totalEmpresas);


	}

}

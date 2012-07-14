package com.indhio.strings;

import java.util.StringTokenizer;


public class Tokenizer {
	
	public static void main(String[] args) {
		System.out.println(getIds("1"));
	}
	
	public static Integer [] getIds(String s) {
		try {
			
			String niveis = s.trim();
			if(niveis != null && !niveis.equals("") && niveis.length() > 0) {
				
				System.out.println("niveis>>> " + niveis);
				int tamanho = niveis.length();
				String pv = niveis.substring(tamanho -1, tamanho);
				if(pv.indexOf(";") == -1) {
					niveis = niveis + ";";
				}
				System.out.println("niveis>>> " + niveis);
				
				int cont = 0;
				StringTokenizer st = new StringTokenizer(niveis, ";");
				int totalTokens = st.countTokens() -1;
				System.out.println("totalTokens >>> " + totalTokens);
				Integer [] predecessoras = new Integer[st.countTokens()];
				while (st.hasMoreTokens()) {
					String id = st.nextToken();
					System.out.println("id >> " + id);
					predecessoras[cont] = Integer.valueOf(id);
					cont++;
				}
				
				
				return predecessoras;
				
			} else {
				Integer [] tmp = new Integer[0];
				tmp[0] = 0;
				return tmp;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	/*public static void main(String[] args) {
		
		String niveis = "10;50.1;12";
		
		try {
			niveis = niveis.trim();
			if(niveis != null && !niveis.equals("")) {
				
				String n1 = niveis.substring(0, 1);
				if(n1.matches("[0-9]")) {
					
					int tamanho = niveis.length();
					String pv = niveis.substring(tamanho -1, tamanho);
					if(pv.indexOf(";") == -1) {
						niveis = niveis + ";";
					}
					System.out.println("niveis>>> " + niveis);
					
					int cont = 0;
					StringTokenizer st = new StringTokenizer(niveis, ";");
					System.out.println("st.countTokens() >>> " + st.countTokens());
					Integer [] predecessoras = new Integer[st.countTokens()];
					while (st.hasMoreTokens()) {
						String id = st.nextToken();
						System.out.println("id >> " + id);
						predecessoras[cont] = Integer.valueOf(id);
						cont++;
					}
					
					if(st.countTokens() == 0) {
						predecessoras = null;
					}
					
					System.out.println("RETURN TRUE");
					
				} else {
					System.out.println("RETURN NULLLLL");
				}
				
			} else {
				System.out.println("RETURN NULLLLL");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
*/
}

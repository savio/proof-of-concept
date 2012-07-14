package com.indhio.strings;

public class SubStrings {
	
	public SubStrings() {
		super();
	}
	
	public static String codigoFormatado(String codigo) {
		String cod = "";
		if(codigo != null) {
			if(codigo.indexOf(".") == -1 && !codigo.equals("")) {
				cod = codigo + ".";
			} else {
				cod = codigo.substring(0, codigo.lastIndexOf(".") + 1);
			}
		}
		System.out.println(cod);
		return cod; 
	}
	
	public static void main(String[] args) {
		
		String s = "1.2";
		if(s.lastIndexOf(".") != -1) {
			System.out.println(s.substring(0, s.lastIndexOf(".")));
			System.out.println(s.substring(s.lastIndexOf(".") + 1, s.length()));
		}
		
		
		/*
		codigoFormatado("3");
		codigoFormatado("3.11");
		codigoFormatado("3.9");
		codigoFormatado("22.8");
		codigoFormatado("22.19");
		*/
	}

}

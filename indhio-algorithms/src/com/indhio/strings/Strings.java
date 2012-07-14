package com.indhio.strings;


public class Strings {

	public static void main(String[] args) {
		/*String nomeArquivo = "=?ISO-8859-1?Q?Usu=E1rio_de_Banco_n=E3o_informado=2Epdf?=";
		nomeArquivo = nomeArquivo.replaceAll("=2E", ".");
		nomeArquivo = nomeArquivo.replaceAll("[^A-Za-z0-9|_|-|.]", "");
		System.out.println(nomeArquivo);*/
		
		String mimeType = "application/pdf; name=\"=?ISO-8859-1?Q?Usu=E1rio_de_Banco_n=E3o_infor?==?ISO-8859-1?Q?mado=2Epdf?=\"";
		if(mimeType.indexOf(";") != 0) {
			mimeType = mimeType.substring(0, mimeType.indexOf(";"));
			System.out.println(mimeType);
		}
		
		
	}
	
}

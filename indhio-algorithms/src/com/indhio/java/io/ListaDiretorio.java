package com.indhio.java.io;

import java.io.File;

public class ListaDiretorio {

	public static void main(String[] args) {
		ListaDiretorio teste = new ListaDiretorio();
		String dir = "/Users/indhio/Root/Developer/empresas/ctis/CTIS/MS_PLATBR_BTR_V2.6_20120529/plataformabrasil-war/src/main/webapp";
		File file = new File(dir);
		teste.listar(file, 0);
	}

	public void listar(File file, int nivel) {
		System.out.print(getIdentacao(nivel));
		if (file.isDirectory()) {
			System.out.print("+ Dir: ");
			System.out.println(file.getName());

			File[] lista = file.listFiles();
			for (int i = 0; i < lista.length; i++) {
				listar(lista[i], nivel + 1);
			}
		} else {
			System.out.print("* Arq: ");
			System.out.println(file.getName());
		}
	}

	private String getIdentacao(int nivel) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < nivel; i++) {
			buffer.append("  ");
		}
		return buffer.toString();
	}

}

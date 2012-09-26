package com.indhio.java.io;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GenerateBreandcrumbProperties implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String PATH = "/Users/indhio/Root/Developer/empresas/ctis/CTIS/MS_PLATBR_BTR_V2.6_20120529/plataformabrasil-war/src/main/webapp";
	private static List<String> filesNames = new ArrayList<String>();

	public static void main(String[] args) {
		listar(new File(PATH));
		for (String str : filesNames) {
			String label = str.replace("/", ".").replace(".xhtml", "=");
			System.out.println(label.substring(1));
		}
	}

	public static void listar(File file) {
		if (file.isDirectory()) {
			File[] lista = file.listFiles();
			for (int i = 0; i < lista.length; i++) {
				listar(lista[i]);
			}
		} else {
			String name = file.getName();
			String absolutePath = file.getAbsolutePath();
			if (isModuloVisao(absolutePath) && name.indexOf(".xhtml") != -1 && name.indexOf(".svn-base") == -1) {
				absolutePath = absolutePath.substring(absolutePath.indexOf(PATH) + PATH.length(), absolutePath.length());
				filesNames.add(absolutePath);
			}
		}
	}

	private static boolean isModuloVisao(String absolutePath) {
		String publico = "/visao/publico/";
		String pesquisador = "/visao/pesquisador/";
		String cep = "/visao/cep/";
		String administrador = "/visao/administrador/";
		return absolutePath.indexOf(publico) != -1 || absolutePath.indexOf(pesquisador) != -1 || absolutePath.indexOf(cep) != -1 || absolutePath.indexOf(administrador) != -1;
	}
}

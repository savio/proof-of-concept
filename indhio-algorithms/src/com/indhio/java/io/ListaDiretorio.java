package com.indhio.java.io;

import java.io.File;

public class ListaDiretorio {

	/** Exibe uma listagem do arquivo ou diretório. */
	public void listar(File file, int nivel) {

		// Exibe a identação necessária
		System.out.print(getIdentacao(nivel));

		if (file.isDirectory()) {
			// Exibe o nome do diretório
			System.out.print("+ Dir: ");
			System.out.println(file.getName());

			File[] lista = file.listFiles();
			// Faz uma chamada recursiva para exibir os arquivos e subdiretórios
			for (int i= 0; i < lista.length; i++)
				listar( lista[i], nivel+1);
		} else {
			// Exibe o nome do arquivo
			System.out.print("* Arq: ");
			System.out.println(file.getName());
		}
	}

	/**
	 * Retorna a quantidade de espaços necessários para o nível especificado.
	 */
	private String getIdentacao(int nivel) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < nivel; i++)
			buffer.append("  ");
		return buffer.toString();
	}

	/** Método principal */
	public static void main(String[] args) {
		ListaDiretorio teste = new ListaDiretorio();

		File file = new File("/home/indhio/assinatura");
		teste.listar(file, 0);
	}

}

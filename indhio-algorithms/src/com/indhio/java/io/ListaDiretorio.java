package com.indhio.java.io;

import java.io.File;

public class ListaDiretorio {

	/** Exibe uma listagem do arquivo ou diret�rio. */
	public void listar(File file, int nivel) {

		// Exibe a identa��o necess�ria
		System.out.print(getIdentacao(nivel));

		if (file.isDirectory()) {
			// Exibe o nome do diret�rio
			System.out.print("+ Dir: ");
			System.out.println(file.getName());

			File[] lista = file.listFiles();
			// Faz uma chamada recursiva para exibir os arquivos e subdiret�rios
			for (int i= 0; i < lista.length; i++)
				listar( lista[i], nivel+1);
		} else {
			// Exibe o nome do arquivo
			System.out.print("* Arq: ");
			System.out.println(file.getName());
		}
	}

	/**
	 * Retorna a quantidade de espa�os necess�rios para o n�vel especificado.
	 */
	private String getIdentacao(int nivel) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < nivel; i++)
			buffer.append("  ");
		return buffer.toString();
	}

	/** M�todo principal */
	public static void main(String[] args) {
		ListaDiretorio teste = new ListaDiretorio();

		File file = new File("/home/indhio/assinatura");
		teste.listar(file, 0);
	}

}

package com.indhio.math.juros;

/**
 * @author Vinicius Nascimento
 */
public class PrestacaoImpl implements CalculoJuros {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.indhio.math.juros.CalculoJuros#calcular()
	 */
	public void calcular() {
		double valorPrestacao = 1200d;
		double periodo = 36d;
		double juros = 2d;
		double valorEmprestimo = formula(valorPrestacao, periodo, juros);
		System.out.println("Valor do Emprestimo: " + valorEmprestimo);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.indhio.math.juros.CalculoJuros#formula(double, double, double)
	 */
	public double formula(double valor, double periodo, double juros) {
		double a = (juros / 100);
		double b = Math.pow((1 + (juros / 100)), periodo);
		double c = Math.pow((1 + (juros / 100)), periodo) - 1;
		double valorTotal = valor * ((c) / (a * b));
		if (valorTotal > 0d) {
			return valorTotal;
		}
		return 0d;
	}

	public static void main(String[] args) {
		new PrestacaoImpl().calcular();
	}

}

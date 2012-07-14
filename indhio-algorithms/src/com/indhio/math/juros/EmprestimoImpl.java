package com.indhio.math.juros;

/**
 * @author Vinicius Nascimento
 */
public class EmprestimoImpl implements CalculoJuros {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.indhio.math.juros.CalculoJuros#calcular()
	 */
	public void calcular() {
		double valorTotal = 30000d;
		double periodo = 36d;
		double juros = 2d;
		double valorPrestacao = formula(valorTotal, periodo, juros);
		System.out.println("Valor da Prestacao: " + valorPrestacao);
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
		double valorPrestacao = valor * ((a * b) / (c));
		if (valorPrestacao > 0d) {
			return valorPrestacao;
		}
		return 0d;
	}
	
	public static void main(String[] args) {
		new EmprestimoImpl().calcular();
	}

}

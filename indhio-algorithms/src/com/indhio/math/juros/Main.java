package com.indhio.math.juros;

public class Main {

	private static final CalculoJuros emprestimoImpl;
	private static final CalculoJuros prestacaoImpl;

	static {
		emprestimoImpl = new EmprestimoImpl();
		prestacaoImpl = new PrestacaoImpl();
	}

	public static void main(String[] args) {
		emprestimoImpl.calcular();
		prestacaoImpl.calcular();
	}

}

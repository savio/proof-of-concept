package com.indhio.math.saldo;

public class SaldoDevedor {

	private double PVista = 0d;// parseFloat(form.Entrada1.value);
	private double Njapagas = 0d;// parseFloat(form.Entrada2.value);
	private double R = 0d;// parseFloat(form.Entrada3.value);
	private double N = 0d;// parseFloat(form.Entrada4.value);

	public void CalculaTaxa() {

		double VFin = PVista;

		double P = VFin;
		double S = P / R;
		double T = 1 / S - S / N / N;

		double A, B;
		for (int cont = 0; cont < 25; cont++) {
			A = Math.pow((1 + T), N);
			B = Math.pow((1 + T), (N + 1));
			T = T - (((A - 1) / (T * A) - S) * B * T * T) / (1 + T * (N + 1) - B);
		}

		// T = parseInt(T*10E8,10)/10E6;

		// int integer = Integer.par(T * 10E8, 10);

		double SaldoD = P;
		double SaldoDevedor = 0d;
		for (int cont = 1; cont < Njapagas + 1; cont++) {
			SaldoDevedor = (SaldoD + (SaldoD * (T / 100))) - R;
			SaldoD = SaldoDevedor;
		}
		SaldoDevedor = Math.round(SaldoDevedor * 100) / 100;
		T = Math.round(T * 100) / 100;

		// {form.Saida1.value=T, form.Saida2.value=SaldoDevedor;}

		return;
	}
}

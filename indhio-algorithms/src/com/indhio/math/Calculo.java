package com.indhio.math;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Vector;

public class Calculo {
	Vector<Double> vs = new Vector<Double>();
	double media, desvioP;

	void loadValues() {
		try {
			FileReader fr = new FileReader("C:\\Documents and Settings\\My Documents\\Novo.txt");
			BufferedReader br = new BufferedReader(fr);
			for (;;) {
				String line = br.readLine();
				if (line == null || line.equals(""))
					break;
				line = line.replace(",", ".");
				vs.add(new Double(line));
			}
			br.close();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	void calcstatistics1() {
		// Calcula media e desvio padrao em dois ciclo
		double m = 0, v = 0;
		int n = vs.size();

		for (int i = 0; i < n; i++)
			m += vs.get(i).doubleValue();

		m /= n;

		for (int i = 0; i < n; i++)
			v += (vs.get(i).doubleValue() - m) * (vs.get(i).doubleValue() - m);
		v /= n;

		media = m;
		desvioP = Math.sqrt(v);
	}

	void calcstatistics2() {
		// Calcula media e desvio padrao em um ciclo
		double m = 0, v = 0;
		int n = vs.size();
		for (int i = 0; i < n; i++) {
			m += vs.get(i).doubleValue();
			v += (vs.get(i).doubleValue() * vs.get(i).doubleValue());
		}

		m /= n;
		v /= n;
		v -= m * m;

		media = m;
		desvioP = Math.sqrt(v);
	}

	void filterValues() throws IOException {
		FileWriter fwA = new FileWriter("C:/Documents and Settings/Desktop/ValoresA.txt", false);
		FileWriter fwR = new FileWriter("C:/Documents and Settings/Desktop/ValoresR.txt", false);
		PrintWriter pwA = new PrintWriter(fwA);
		PrintWriter pwR = new PrintWriter(fwR);

		try {
			pwR.printf("# Rejeitados \n");
			pwR.printf("# N = " + vs.size() + "\n");
			pwR.printf("# media = " + media + "\n");
			pwR.printf("# desvioP = " + desvioP + "\n");
			pwR.printf("# media - desvioP = " + (media - desvioP) + "\n");
			pwR.printf("#\n");

			pwA.printf("# Aceites \n");
			pwA.printf("# N = " + vs.size() + "\n");
			pwA.printf("# media = " + media + "\n");
			pwA.printf("# desvioP = " + desvioP + "\n");
			pwA.printf("# media - desvioP = " + (media - desvioP) + "\n");
			pwA.printf("#\n");

			int n = vs.size();
			for (int i = 0; i < n; i++) {
				if (vs.get(i).doubleValue() < Math.abs(media - desvioP))
					pwR.printf(Locale.getDefault(), "%.16f\n", vs.get(i).doubleValue());
				else
					pwA.printf(Locale.getDefault(), "%.16f\n", vs.get(i).doubleValue());
				;
			}
		} catch (Throwable t) {
			t.printStackTrace();
		} finally {
			fwA.close();
			pwA.close();
			fwR.close();
			pwR.close();
		}
	}

	public static void main(String[] args) throws IOException {
		Calculo c = new Calculo();
		c.loadValues();
		// c.calcstatistics1();
		c.calcstatistics2();
		c.filterValues();

		System.out.println("Terminou:)!");
	}
}
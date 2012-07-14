package com.indhio.datahora;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Calendario {

	static NumberFormat formatter = new DecimalFormat("00");

	public static void main(String[] args) {
		for (int i = 0; i <= 11; i++)
			printCalendar(2009, i, 1);
	}

	public static void printCalendar(int year, int mounth, int day) {
		Calendar cal = new GregorianCalendar(year, mounth, day);
		boolean inicio = false;
		System.out.println("D  S  T  Q  Q  S  S");

		for (int i = 1; i <= 6; i++) {// semanas
			for (int w = 1; w <= 7; w++) {// dias
				if (w == cal.get(Calendar.DAY_OF_WEEK)) {
					inicio = true;
				}// início da escrita
				if (inicio) {
					if ((day - 1) == cal.getActualMaximum(Calendar.DAY_OF_MONTH)) {
						break;
					}// parada no final do mês
					System.out.print(formatter.format(day++) + " ");
				} else {
					System.out.print("   ");
				}
			}
			System.out.println();
		}
	}
}
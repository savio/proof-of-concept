package com.indhio.locale;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;

public class TesteHorarioVeraoSun {

	public static void main(String[] args) {
		// Cria uma TIME ZONE correspondente ao horário de Brasília
		SimpleTimeZone pdt = new SimpleTimeZone(-3 * 60 * 60 * 1000, "GMT-3:00");

		// Seta as regras para o horário de verão Brasileiro
		// Começando no primeiro domingo após o dia primeiro
		pdt.setStartRule(Calendar.NOVEMBER, 1, Calendar.SUNDAY, 0);

		// Terminando no último domingo do mês de Fevereiro
		pdt.setEndRule(Calendar.FEBRUARY, -1, Calendar.SUNDAY, 0);

		// Instanciando um GregorianCalendar com com a time zone de BSB
		// e levando em consideração as regras do horário de verão.
		Calendar dataHoje = new GregorianCalendar(pdt);

		System.out.println(dataHoje.get(Calendar.HOUR_OF_DAY) + ":" + dataHoje.get(Calendar.MINUTE) + ":" + dataHoje.get(Calendar.SECOND));
	}
}

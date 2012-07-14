package com.indhio.datahora;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OperacaoHora {
	
	public static void main(String[] args) {
		int hora = -9;
		if(hora < 0) {
			hora = hora * (-1);
		}
		System.out.println(hora);
		
		
		String hora1 = "10:30";
		String hora2 = "10:50";
		System.out.println(" >>> " + subtraiHora(hora1, hora2));
	}
	
	public static String subtraiHora(String hora, String hora2) {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");

		long h_1 = getHoras(hora, formatter);
		long h_2 = getHoras(hora2, formatter);
		long min_1 = getMinutos(hora, formatter);
		long min_2 = getMinutos(hora2, formatter);
		long result = (h_1 - h_2) * (min_1 - min_2) * 60 * 1000;
		Date data = new Date(result);
		return formatter.format(data);
	}
	
	private static long getHoras(String hora, SimpleDateFormat formatter) {
		Date data;
		try {
			data = formatter.parse(hora);
		} catch (ParseException e) {
			return 0;
		}
		long horas = data.getTime() / 1000 / 60 / 60;
		return horas;
	}

	private static long getMinutos(String hora, SimpleDateFormat formatter) {
		Date data;
		try {
			data = formatter.parse(hora);
		} catch (ParseException e) {
			return 0;
		}
		long minutos = data.getTime() / 1000 / 60;
		return minutos;
	}

}

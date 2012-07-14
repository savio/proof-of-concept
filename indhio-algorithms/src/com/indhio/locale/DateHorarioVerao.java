package com.indhio.locale;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateHorarioVerao {
	
	public static void main(String[] args) throws ParseException {
		Date data = new Date();
		
		Locale locale = new Locale("pt", "BR");
	      Locale.setDefault(locale);
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", locale);
		
		System.out.println(data);
		
		String hora = "10:10";
		System.out.println(sdf.parse(hora));
	}

}

package com.indhio.locale;

import java.text.SimpleDateFormat;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class Dt {
	
	public static void main(String args[]) {
		try {
			// define a nossa TimeZone customizada
			SimpleTimeZone tmz = new SimpleTimeZone(TimeZone.getDefault().getRawOffset(), "MTZ");
			tmz.setStartRule(10, 2, 0);// começa dia 02/11
			tmz.setEndRule(1, 20, 0);// termina dia 20/02
			TimeZone.setDefault(tmz);// altera a TimeZone default

			SimpleDateFormat fd = new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date ud = fd.parse("02/11/2004");
			System.out.println("java.util.Date: " + ud);

			java.sql.Date sd = java.sql.Date.valueOf("2004-11-02");
			System.out.println("java.sql.Date : " + sd);
		} catch (Exception eError) {
			System.err.println("erro:" + eError.getMessage());
		}
	}
	
}
package com.indhio.locale;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;

public class TesteHorarioVerao {
	public static void main(String[] args) {
		SimpleTimeZone pdt = new SimpleTimeZone(-3 * 60 * 60 * 1000, "GMT-3:00");

		pdt.setStartRule(10, 2, 0);
		pdt.setEndRule(1, 20, 0);

		Calendar d = new GregorianCalendar(pdt);
		for (int i = 1; i <= 3; i++) {
			d.set(d.DAY_OF_MONTH, i);
			d.set(d.MONTH, 10);
			d.set(d.YEAR, 2007);
			d.set(d.HOUR_OF_DAY, 0);
			d.set(d.MINUTE, 0);
			d.set(d.SECOND, 0);
			System.out.println("Calendar:" + d.getTime() + " " + (pdt.inDaylightTime(d.getTime()) ? "daylight" : "regular"));
		}
	}
}

package com.indhio.locale;

import java.util.*;

class Test192 {

	public static void main(String[] args) {

		TimeZone tz = TimeZone.getTimeZone("America/Sao_Paulo");
		TimeZone.setDefault(tz);
		Calendar ca = GregorianCalendar.getInstance(tz);

		System.out.println(ca.getTime());
	}

}
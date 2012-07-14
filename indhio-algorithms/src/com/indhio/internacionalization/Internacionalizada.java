package com.indhio.internacionalization;

import java.util.Locale;
import java.util.ResourceBundle;

public class Internacionalizada {

	public static void main(String[] args) {

		final Locale defaultLocale = Locale.getDefault();
		final ResourceBundle rbDefault = ResourceBundle.getBundle("ResourceBundle", defaultLocale);

		System.out.println(new StringBuilder().append(rbDefault.getString("name")).append(": Jean Jorge Michel"));
		System.out.println(new StringBuilder().append(rbDefault.getString("username")).append(": jmichel"));
		System.out.println(new StringBuilder().append(rbDefault.getString("password")).append(": minhasenhaultrasecreta").append("\n\n"));

		final Locale otherLocale = new Locale("en", "US");
		final ResourceBundle rb = ResourceBundle.getBundle("ResourceBundle", otherLocale);

		System.out.println(new StringBuilder().append(rb.getString("name")).append(": Jean Jorge Michel"));
		System.out.println(new StringBuilder().append(rb.getString("username")).append(": jmichel"));
		System.out.println(new StringBuilder().append(rb.getString("password")).append(": minhasenhaultrasecreta"));
	}
}

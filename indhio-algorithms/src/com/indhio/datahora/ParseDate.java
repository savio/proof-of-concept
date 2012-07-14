package com.indhio.datahora;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ParseDate {
	
	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		System.out.println(new java.sql.Date(new java.util.Date("12/12/2000").getTime()).toString());
		
		String valor = "10/12/2000";
		System.out.println(valor.matches("[0-3][0-9]/[01][0-9]/[12][0-9][0-9][0-9]"));
		
		try {
			System.out.println(sdf.parse("12/12/2000"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
}

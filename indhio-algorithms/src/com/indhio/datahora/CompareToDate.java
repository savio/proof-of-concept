package com.indhio.datahora;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CompareToDate {
	
	public static void main(String[] args) {
		
		Calendar dataRetorno = new GregorianCalendar();
		dataRetorno.set(2008, 4, 12);
		
		Calendar data = new GregorianCalendar();
		data.setTimeInMillis(new java.util.Date().getTime());
		
		System.out.println(data.get(Calendar.DATE) + "/" + data.get(Calendar.MONTH) + "/" + data.get(Calendar.YEAR));
		System.out.println(dataRetorno.get(Calendar.DATE) + "/" + dataRetorno.get(Calendar.MONTH) + "/" + dataRetorno.get(Calendar.YEAR));
		
		System.out.println(dataRetorno.equals(data));
		System.out.println(dataRetorno.before(data));
		System.out.println(dataRetorno.after(data));
		
	}

}

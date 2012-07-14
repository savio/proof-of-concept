package com.indhio.datahora;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TimeTime {
	
	public static void main(String[] args) {
		
		Calendar data = new GregorianCalendar();
		data.setTime(new java.util.Date());
		data.set(Calendar.HOUR_OF_DAY, 0);
		data.set(Calendar.MINUTE, 0);
		data.set(Calendar.SECOND, 0);
		data.set(Calendar.MILLISECOND, 0);
		
		Timestamp timestamp = new Timestamp(data.getTimeInMillis());
		
		System.out.println(timestamp);
		
	}

}

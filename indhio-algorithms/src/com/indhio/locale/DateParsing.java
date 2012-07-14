package com.indhio.locale;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
 
public class DateParsing {
	public static void main(String args[]){
		// here I run the program the default way
		System.out.println("\nBEFORE\n--------------------------------------------------------------------");
		showDate("01/11/2004");
		showDate("02/11/2004");
		showDate("03/11/2004");
		
		// here I create a new TimeZone, with user defined
		// start and end rules
		SimpleTimeZone mtz = new SimpleTimeZone(TimeZone.getDefault().getRawOffset(),"America/Sao_Paulo");
		//mtz.setStartRule(10,2,0);	// November, 2, 00:00, starts, goes to November, 3, 01:00, right?
		//mtz.setEndRule(1,20,0);		// February, 20, 00:00, ends, goes to February, 19, 23:00, right?
		TimeZone.setDefault(mtz);	// set this zone as the default one
		
		// now print the values
		System.out.println("\nAFTER\n---------------------------------------------------------------------");
		showDate("01/11/2004");
		showDate("02/11/2004");
		showDate("03/11/2004");
	}
 
	public static void showDate(String date){
		try{
			SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		
			// regular Date	
			java.util.Date dt = fmt.parse(date);
			System.out.println("java.util.date ("+date+") : "+dt);
 
			// SQL date
			String day	= date.substring(0,2);
			String month= date.substring(3,5);
			String year	= date.substring(6);
			String sql  = year+"-"+month+"-"+day;
			java.sql.Date  sd = java.sql.Date.valueOf(sql);
			System.out.println("java.sql.date  ("+sql+") : "+sd);
 
			// Calendar date
			Calendar cal = Calendar.getInstance();
			cal.set(cal.DAY_OF_MONTH,Integer.parseInt(day));
			cal.set(cal.MONTH,Integer.parseInt(month)-1);
			cal.set(cal.YEAR,Integer.parseInt(year));
			cal.set(cal.HOUR_OF_DAY,0);
			cal.set(cal.MINUTE,0);
			cal.set(cal.SECOND,0);
			System.out.println("calendar date  ("+sql+") : "+cal.getTime());
			
			// Calendar date plus one hour
			cal = Calendar.getInstance();
			cal.set(cal.DAY_OF_MONTH,Integer.parseInt(day));
			cal.set(cal.MONTH,Integer.parseInt(month)-1);
			cal.set(cal.YEAR,Integer.parseInt(year));
			cal.set(cal.HOUR_OF_DAY,1);
			cal.set(cal.MINUTE,0);
			cal.set(cal.SECOND,0);
			System.out.println("calendar date +("+sql+") : "+cal.getTime());
			System.out.println("");
 
		}catch(Exception e){
			System.err.println("ERROR SHOWING "+date+" : "+e.getMessage());
		}	
	}
}


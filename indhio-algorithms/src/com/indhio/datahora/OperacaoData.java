package com.indhio.datahora;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class OperacaoData {
	
	public static void main(String[] args) throws ParseException {
		String mes = "1";
		String ano = "2007";
		
		String di =  "1/" + Integer.parseInt(mes) + "/" + ano;
		String df =  "1/" + (Integer.parseInt(mes) + 1) + "/" + ano;
		
		System.out.println(di);
		System.out.println(df);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		java.sql.Date dataInicio = new java.sql.Date(sdf.parse(di).getTime());
		java.sql.Date dataFim = new java.sql.Date(sdf.parse(df).getTime());
		
		System.out.println(dataInicio);
		System.out.println(dataFim);
	}

}

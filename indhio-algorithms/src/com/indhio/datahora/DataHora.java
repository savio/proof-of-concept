package com.indhio.datahora;

public class DataHora {
	
	public static void main(String[] args) {
		System.out.println(new java.util.Date());
		System.out.println(new java.sql.Date(new java.util.Date().getTime()));
		System.out.println(new java.util.Date());
	}

}

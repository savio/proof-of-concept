package com.indhio.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Testa {
	String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
	String DBQ = "\\dnecom.mdb";
	String url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=" + DBQ;
	String username = "";
	String password = "";

	Connection con;
	Statement stmt;

	public void openDB() {

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			stmt = con.createStatement();
			System.out.println("\nConexao estabelecida com Sucesso!\n");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("\n Erro ao carregar JDBC / ODBC driver !\n" + e + "\n");
			System.exit(1);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("\nNao foi possivel estabelecer conexao\n" + e + "\n");
			System.exit(1);
		}
	}

	public void closeDB() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("\n Nao foi prossivel fechar conexao" + e + "\n");
			System.exit(1);
		}
	}

	public static void main(String[] args) {
		Testa t = new Testa();
		t.openDB();
		t.closeDB();
	}

}
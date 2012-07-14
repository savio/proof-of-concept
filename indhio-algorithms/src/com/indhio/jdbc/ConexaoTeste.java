package com.indhio.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoTeste {

	public static void main(String args[]) throws SQLException {

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://192.168.1.4;databaseName=volkswagen", "lms", "SqlserveR@XnX158");
			System.out.println("Conectado!");
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
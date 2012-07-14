package com.indhio.testng.test;

import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.DefaultDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.operation.DatabaseOperation;

public final class TestHelper {

	public static void clearTable(String tableName) throws Exception {
		JdbcDatabaseTester tester = new JdbcDatabaseTester(
				"org.postgresql.Driver", 
				"jdbc:postgresql://localhost:5432/indhio-testng",
				"indhio",
				"indhio");
		IDatabaseConnection conn = tester.getConnection();
		ITable table = conn.createTable(tableName);
		IDataSet dataSet = new DefaultDataSet(table);
		DatabaseOperation.DELETE_ALL.execute(conn, dataSet);
	}
}

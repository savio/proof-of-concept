package com.indhio.testng.test;

import java.lang.annotation.Annotation;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Table;

import com.indhio.testng.entity.Grupo;

public class TestTools {

	protected EntityManagerFactory entityManagerFactory;

	private final String persistenceUnitName = "IndhioTestNGPU";

	public void configJPA() {
		entityManagerFactory = Persistence.createEntityManagerFactory(this.persistenceUnitName);
	}

	public void clearTable(Class aClass) throws Exception {
		String table = "";
		Annotation annotation = aClass.getAnnotation(Table.class);
		if (annotation instanceof Table) {
			Table aTable = (Table) annotation;
			table = aTable.name();
			// System.out.println("value: " + aTable.name());
		}
		TestHelper.clearTable(table);
	}

	public static void main(String[] args) throws Exception {
		new TestTools().clearTable(Grupo.class);
	}

}

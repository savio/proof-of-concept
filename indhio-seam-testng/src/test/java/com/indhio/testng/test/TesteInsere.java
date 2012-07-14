package com.indhio.testng.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TesteInsere {

	public static void main(String[] args) {
		EntityManager entityManager = Persistence.createEntityManagerFactory("IndhioTestNGDU").createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		//		
		// Empresa empresa = new Empresa();
		// empresa.setCnpj("01.645.738/0001-79");
		// empresa.setRazaoSocial("Politec LTDA");
		//		
		// Lance lance = new Lance();
		// lance.setValor(new BigDecimal(100.0));
		// lance.setDataHora(new Date());
		// //lance.setEmpresa(empresa);
		//		
		// empresa.getLances().add(lance);
		//		
		// entityManager.persist(empresa);
		
		entityTransaction.commit();
	}
}

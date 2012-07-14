package com.indhio.testng.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.indhio.testng.entity.Perfil;

@Test(testName = "com.indhio.testng.test.PerfilTest")
public class PerfilTest extends TestTools {

	public PerfilTest() {
		super.configJPA();
	}

	@BeforeClass
	public void initDatabase() throws Exception {
		super.clearTable(Perfil.class);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void insert() throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		Perfil entity = new Perfil();
		entity.setCnpj("00.000.000/0001-00");
		entity.setRazaoSocial("Teste de Perfil Razao Social");

		try {
			entityManager.persist(entity);
			entityTransaction.commit();
		} catch (Exception e) {
			entityTransaction.rollback();
			throw e;
		}

		entityManager = entityManagerFactory.createEntityManager();
		List<Perfil> list = (List<Perfil>) entityManager.createQuery("from Perfil").getResultList();
		if (!list.isEmpty()) {
			Assert.assertEquals(entity.getCnpj(), list.iterator().next().getCnpj());
			Assert.assertEquals(entity.getRazaoSocial(), list.iterator().next().getRazaoSocial());
		} else {
			Assert.fail("Lista vazia");
		}
	}

	@SuppressWarnings("unchecked")
	@Test(dependsOnMethods = { "insert" })
	public void update() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Perfil entity = null;

		// Obtem um registro do banco de dados (o primeiro)
		List<Perfil> list = (List<Perfil>) entityManager.createQuery("from Perfil").getResultList();
		if (!list.isEmpty()) {
			entity = list.iterator().next();
		} else {
			Assert.fail("Lista vazia");
		}

		// Atualiza o registro (o campo descricao)
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		Long id = entity.getId();
		entity.setRazaoSocial("Bingo");

		entityManager.persist(entity);

		entityTransaction.commit();

		// Consulta o registro e verifica se foi corretamente atualizado
		entityManager = entityManagerFactory.createEntityManager();
		Perfil test = entityManager.find(Perfil.class, id);
		if (test != null) {
			Assert.assertEquals(test.getRazaoSocial(), entity.getRazaoSocial());
		} else {
			Assert.fail("Registro nao encontrado");
		}
	}

	@SuppressWarnings("unchecked")
	@Test(dependsOnMethods = { "update" })
	public void delete() {
		// Exclui todos os registros
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		List<Perfil> list = (List<Perfil>) entityManager.createQuery("from Perfil").getResultList();
		for (Perfil entity : list) {
			entityManager.remove(entity);
		}

		entityTransaction.commit();

		// Consulta e verifica se a lista esta vazia
		list = (List<Perfil>) entityManager.createQuery("from Perfil").getResultList();
		Assert.assertEquals(list.isEmpty(), true);
	}
}

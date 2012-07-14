package com.indhio.testng.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.indhio.testng.entity.Grupo;

@Test(testName = "com.indhio.testng.test.GrupoTest")
public class GrupoTest extends TestTools {

	public GrupoTest() {
		super.configJPA();
	}

	@BeforeClass
	public void initDatabase() throws Exception {
		super.clearTable(Grupo.class);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void insert() throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		Grupo entity = new Grupo();
		entity.setNome("Teste de Grupo");

		try {
			entityManager.persist(entity);
			entityTransaction.commit();
		} catch (Exception e) {
			entityTransaction.rollback();
			throw e;
		}

		entityManager = entityManagerFactory.createEntityManager();
		List<Grupo> list = (List<Grupo>) entityManager.createQuery("from Grupo").getResultList();
		if (!list.isEmpty()) {
			Assert.assertEquals(entity.getNome(), list.iterator().next().getNome());
		} else {
			Assert.fail("Lista vazia");
		}
	}

	@SuppressWarnings("unchecked")
	@Test(dependsOnMethods = { "insert" })
	public void update() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Grupo entity = null;

		// Obtem um registro do banco de dados (o primeiro)
		List<Grupo> list = (List<Grupo>) entityManager.createQuery("from Grupo").getResultList();
		if (!list.isEmpty()) {
			entity = list.iterator().next();
		} else {
			Assert.fail("Lista vazia");
		}

		// Atualiza o registro (o campo descricao)
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		Long id = entity.getId();
		entity.setNome("Teste de alteracao do nome do usuario");

		entityManager.persist(entity);

		entityTransaction.commit();

		// Consulta o registro e verifica se foi corretamente atualizado
		entityManager = entityManagerFactory.createEntityManager();
		Grupo test = entityManager.find(Grupo.class, id);
		if (test != null) {
			Assert.assertEquals(test.getNome(), entity.getNome());
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

		List<Grupo> list = (List<Grupo>) entityManager.createQuery("from Grupo").getResultList();
		for (Grupo entity : list) {
			entityManager.remove(entity);
		}

		entityTransaction.commit();

		// Consulta e verifica se a lista esta vazia
		list = (List<Grupo>) entityManager.createQuery("from Grupo").getResultList();
		Assert.assertEquals(list.isEmpty(), true);
	}
}

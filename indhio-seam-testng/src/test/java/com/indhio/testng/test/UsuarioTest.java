package com.indhio.testng.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.indhio.testng.entity.Usuario;

@Test(testName = "com.indhio.testng.test.UsuarioTest")
public class UsuarioTest extends TestTools {

	public UsuarioTest() {
		super.configJPA();
	}

	@BeforeClass
	public void initDatabase() throws Exception {
		super.clearTable(Usuario.class);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void insert() throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		Usuario entity = new Usuario();
		entity.setNome("Teste de Usuario");

		try {
			entityManager.persist(entity);
			entityTransaction.commit();
		} catch (Exception e) {
			entityTransaction.rollback();
			throw e;
		}

		entityManager = entityManagerFactory.createEntityManager();
		List<Usuario> list = (List<Usuario>) entityManager.createQuery("from Usuario").getResultList();
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

		Usuario entity = null;

		// Obtem um registro do banco de dados (o primeiro)
		List<Usuario> list = (List<Usuario>) entityManager.createQuery("from Usuario").getResultList();
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
		Usuario test = entityManager.find(Usuario.class, id);
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

		List<Usuario> list = (List<Usuario>) entityManager.createQuery("from Usuario").getResultList();
		for (Usuario entity : list) {
			entityManager.remove(entity);
		}

		entityTransaction.commit();

		// Consulta e verifica se a lista esta vazia
		list = (List<Usuario>) entityManager.createQuery("from Usuario").getResultList();
		Assert.assertEquals(list.isEmpty(), true);
	}
}

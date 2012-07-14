package com.indhio.testng.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;

import org.jboss.seam.annotations.In;

public class AbstractDAO<T> {

	@In
	protected EntityManager entityManager;

	protected Class<T> entityClass;

	public void save(T entity) {
		entityManager.persist(entity);
	}

	public void save(List<T> entities) {
		for (T entity : entities) {
			save(entity);
		}
	}

	public T findById(Object id) {
		return entityManager.find(getEntityClass(), id);
	}

	public void remove(T entity) {
		entityManager.remove(entity);
	}

	@SuppressWarnings("unchecked")
	protected Class<T> getEntityClass() {
		if (entityClass == null) {
			Type type = getClass().getGenericSuperclass();
			if (type instanceof ParameterizedType) {
				ParameterizedType paramType = (ParameterizedType) type;
				entityClass = (Class<T>) paramType.getActualTypeArguments()[0];
			} else {
				throw new IllegalArgumentException("Erro ao tentar obter o tipo de classe da entidade");
			}
		}

		return entityClass;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}

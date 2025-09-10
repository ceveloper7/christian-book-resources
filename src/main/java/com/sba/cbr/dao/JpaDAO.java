package com.sba.cbr.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class JpaDAO<E> {
	protected EntityManager entityManager;
	protected EntityTransaction transaction;
	
	public JpaDAO(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
		transaction = entityManager.getTransaction();
	}
	
	public E create(E entity) {
		transaction.begin();
		entityManager.persist(entity);
		entityManager.flush();
		entityManager.refresh(entity);
		transaction.commit();
		return entity;
	}
	
	public E update(E entity) {
		transaction.begin();
		entityManager.merge(entity);
		transaction.commit();
		return entity;
	}
}

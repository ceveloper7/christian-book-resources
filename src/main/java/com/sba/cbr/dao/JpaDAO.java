package com.sba.cbr.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class JpaDAO<E> {
	protected EntityManager entityManager;
	protected EntityTransaction transaction;
	
	public JpaDAO(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
		this.transaction = entityManager.getTransaction();
	}
	
	public E create(E entity) {
		try {
			transaction.begin();
			entityManager.persist(entity);
			entityManager.flush();
			entityManager.refresh(entity);
			transaction.commit();
		}
		catch(Exception ex) {
			if (transaction.isActive()) {
	            transaction.rollback();
	        }
			ex.printStackTrace();
		}
		
		return entity;
	}
	
	public E update(E entity) {
		try {
			transaction.begin();
			entityManager.merge(entity);
			transaction.commit();
		}
		catch(Exception ex) {
			if (transaction.isActive()) {
	            transaction.rollback();
	        }
			ex.printStackTrace();
		}
		
		return entity;
	}
	
	public E find(Class<E> type, Object id) {
		E entity = entityManager.find(type, id);
		if(entity != null)
			entityManager.refresh(entity);
		return entity;
	}
	
	public void delete(Class<E> type, Object id) throws EntityNotFoundException{
		try {
			transaction.begin();
			Object reference = entityManager.getReference(type, id);
			entityManager.remove(reference);
			transaction.commit();
		}
		catch(EntityNotFoundException ex) {
			throw new EntityNotFoundException();
		}
	}
	
	public List<E> findWithNamedQuery(String queryName){
		Query query = entityManager.createNamedQuery(queryName);
		return query.getResultList();
	}
	
}

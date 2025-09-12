package com.sba.cbr.entity;

import java.time.LocalDateTime;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CategoryTest {
	public static void main(String[] args) {
		
		Category cat = new Category();
		cat.setName("Gospel");
		
		AuditFields au = new AuditFields
				.Builder(19, LocalDateTime.now(), 19, LocalDateTime.now())
				.build();
		
		cat.setAuditFields(au);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cbr");
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		try {
			transaction.begin();
			em.persist(cat);
			transaction.commit();
		}
		catch(Exception e) {
			if (transaction.isActive()) {
	            transaction.rollback();
	        }
			e.printStackTrace();
		}
		finally {
			em.close();
			emf.close();
		}
		
		System.out.println("A category object was persisted");
	}
}

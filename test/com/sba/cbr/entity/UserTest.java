package com.sba.cbr.entity;

import java.time.LocalDateTime;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class UserTest {
	public static void main(String[] args) {
		
		AuditFields au = new AuditFields
				.Builder(19, LocalDateTime.now(), 19, LocalDateTime.now())
				.build();
		
		User user = new User.Builder("barcvilla@gmail.com", "ms$_tg", "Benedicto Carranza")
					.withAudits(au)
					.isActive(true)
					.build();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cbr");
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		try {
			transaction.begin();
			em.persist(user);
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
		
		System.out.println("A user object was persisted");
	}
}

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
		
		User user = new User.Builder("t.palacios@gmail.com", "_palacio$%", "Tatania Palacios")
					.withAudits(au)
					.isActive(true)
					.build();
		
		EntityTransaction transaction = null;
		
		try(
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("cbr");
			EntityManager em = emf.createEntityManager();) 
		{
			transaction = em.getTransaction();
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
//		finally {
//			em.close();
//			emf.close();
//		}
		
		System.out.println("A user object was persisted");
	}
}

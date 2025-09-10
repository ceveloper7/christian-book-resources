package com.sba.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.sba.cbr.dao.UserDAO;
import com.sba.cbr.entity.AuditFields;
import com.sba.cbr.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class UserDAOTest {
	
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static EntityTransaction transaction;
	private static UserDAO userDAO;
	
	@BeforeAll
	public static void setUpClass() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cbr");
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		UserDAO userDAO = new UserDAO(em);
	}
	
	@Test
	public void testCreateUser() {
		
		User user = new User();
		user.setEmail("p.diaz@gmail.com");
		user.setFullname("Pablo Diaz");
		user.setPassword("pd_34@.");
		
		AuditFields au = new AuditFields();
		au.setCreated_by(19);
		au.setCreated_at(LocalDateTime.now());
		au.setUpdated_by(19);
		au.setUpdated_at(LocalDateTime.now());
		
		user.setAuditFields(au);
		
		try {
			
			user = userDAO.create(user);
			
			assertTrue(user.getId() > 0);
		}
		catch(Exception e) {
			if (transaction.isActive()) {
	            transaction.rollback();
	        }
			e.printStackTrace();
		}
		
		System.out.println("A user object was persisted");
	}
	
	@Test
	public void testCreateUserFieldNotSet() {
		User user = new User();
		
		try {
			
			user = userDAO.create(user);
			
			assertTrue(user.getId() > 0);
		}
		catch(Exception e) {
			if (transaction.isActive()) {
	            transaction.rollback();
	        }
			e.printStackTrace();
		}
		
		System.out.println("A user object was persisted");	
	}
	
	@AfterAll
	public static void tearDownClass() {
		em.close();
		emf.close();
	}

}

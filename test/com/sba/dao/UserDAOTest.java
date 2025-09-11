package com.sba.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.sba.cbr.dao.UserDAO;
import com.sba.cbr.entity.AuditFields;
import com.sba.cbr.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@DisplayName("User Data Acces Object Test")
public class UserDAOTest {
	
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static UserDAO userDAO;
	
	@BeforeAll
	public static void setUpClass() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cbr");
		EntityManager em = emf.createEntityManager();
		//EntityTransaction transaction = em.getTransaction();
		
		userDAO = new UserDAO(em);
	}
	
	@DisplayName("Create User Test")
	@Test
	public void testCreateUser() {
		
		User user = new User();
		user.setEmail("a.gomez@gmail.com");
		user.setFullname("Alberto Gomez");
		user.setPassword("mstre@.");
		
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
			
			e.printStackTrace();
		}
		
		System.out.println("A user object was persisted");
	}
	
	@DisplayName("Create User with fields not set")
	@Test
	@Disabled
	public void testCreateUserFieldNotSet() {
		User user = new User();
		
		try {
			
			user = userDAO.create(user);
			
			assertTrue(user.getId() > 0);
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		System.out.println("A user object was persisted");	
	}
	
	@DisplayName("Update User Test")
	@Test
	public void testUpdateUser() {
		User user = new User();
		
		user.setId(21);
		user.setEmail("p.diaz@gmail.com");
		user.setPassword("pd_340@.");
		user.setFullname("Pablo Diaz");
		
		AuditFields audit = new AuditFields();
		audit.setCreated_by(19);
		audit.setCreated_at(LocalDateTime.now());
		audit.setUpdated_by(19);
		audit.setUpdated_at(LocalDateTime.now());
		
		user.setAuditFields(audit);
		user.setActive(true);
		
		user = userDAO.update(user);
		String expected = "pd_340@.";
		String actual = user.getPassword();
		
		assertEquals(expected, actual);
		
	}
	
	@AfterAll
	public static void tearDownClass() {
		em.close();
		emf.close();
	}

}

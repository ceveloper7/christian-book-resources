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
		
		AuditFields au = new AuditFields();
		au.setCreated_by(19);
		au.setCreated_at(LocalDateTime.now());
		au.setUpdated_by(19);
		au.setUpdated_at(LocalDateTime.now());
		
		try {
			User user = new User.Builder("m.pinedo@gmail.com", "p_@3@.", "Mario Pinedo")
					.withAudits(au)
					.isActive(true)
					.build();
			
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
		//User user = new User();
		
//		try {
//			
//			user = userDAO.create(user);
//			
//			assertTrue(user.getId() > 0);
//		}
//		catch(Exception e) {
//			
//			e.printStackTrace();
//		}
		
		System.out.println("A user object was persisted");	
	}
	
	@DisplayName("Update User Test")
	@Test
	public void testUpdateUser() {
		AuditFields audit = new AuditFields();
		audit.setCreated_by(19);
		audit.setCreated_at(LocalDateTime.now());
		audit.setUpdated_by(19);
		audit.setUpdated_at(LocalDateTime.now());
		
		User user = new User.Builder("g.pinedo@gmail.com", "g_@3@.", "Gloria Pinedo")
					.withAudits(audit)
					.isActive(true)
					.build();
		user.setId(25);
		System.out.println(user.getId() + " " + user.getFullname() + " " + user.getPassword());
		user = userDAO.update(user);
		String expected = "g_@3@.";
		String actual = user.getPassword();
		
		assertEquals(expected, actual);
	}
	
	@AfterAll
	public static void tearDownClass() {
		em.close();
		emf.close();
	}

}

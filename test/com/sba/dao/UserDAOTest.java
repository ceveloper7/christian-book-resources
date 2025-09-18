package com.sba.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.sba.cbr.dao.UserDAO;
import com.sba.cbr.dataobjects.RUser;
import com.sba.cbr.entity.AuditFields;
import com.sba.cbr.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;

@DisplayName("User Data Acces Object Test")
public class UserDAOTest {
	
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static UserDAO userDAO;
	
	@BeforeAll
	public static void setUpClass() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cbr");
		EntityManager em = emf.createEntityManager();
		userDAO = new UserDAO(em);
	}
	
	@DisplayName("Create User Test")
	@Test
	public void testCreateUser() {
		
		try {
			User user = new User.Builder("a.clossa@gmail.com", "acl#@$^", "Andrea Clossa", 19, 19, true)
					.build();
			
			user = userDAO.create(user);
			assertTrue(user.getId() > 0);
			assertTrue(user.isActive());
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		System.out.println("A user object was persisted");
	}
	
	@DisplayName("Exception produced with User fields not set")
	@Test
	@Disabled
	public void testCreateUserFieldNotSet() {
		User user = new User();
		user = userDAO.create(user);
		
		System.out.println("A user object was persisted");	
	}
	
	@DisplayName("Update User Test")
	@Test
	public void testUpdateUser() {
		
		User user = new User.Builder("a.closa@gmail.com", "acl#@$^", "Andrea Closa", 19, 19, true)
					.build();
		user.setId(36);
		user = userDAO.update(user);
		String expected = "acl#@$^";
		String actual = user.getPassword();
		
		assertEquals(expected, actual);
	}
	
	@AfterAll
	public static void tearDownClass() {
		if(em != null)
			em.close();
		
		if(emf != null)
			emf.close();
	}

}

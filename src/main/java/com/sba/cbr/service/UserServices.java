package com.sba.cbr.service;

import java.util.List;

import com.sba.cbr.dao.UserDAO;
import com.sba.cbr.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserServices {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private UserDAO userDAO;
	
	public UserServices() {
		entityManagerFactory = Persistence.createEntityManagerFactory("cbr");
		entityManager = entityManagerFactory.createEntityManager();
		userDAO = new UserDAO(entityManager);
	}
	
	public List<User> listUser() {
		List<User> users = userDAO.listAllActive();
		return users;
	}	
}

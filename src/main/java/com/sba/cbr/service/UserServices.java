package com.sba.cbr.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import com.sba.cbr.dao.UserDAO;
import com.sba.cbr.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserServices {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private UserDAO userDAO;
	
	public UserServices() {
		entityManagerFactory = Persistence.createEntityManagerFactory("cbr");
		entityManager = entityManagerFactory.createEntityManager();
		userDAO = new UserDAO(entityManager);
	}
	
	
	public void listUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		List<User> listUsers = userDAO.listAllActive();
		
		request.setAttribute("listUsers", listUsers);
		request.setAttribute("message", "New user created successfully");
		
		String listPage = "user_list.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
		requestDispatcher.forward(request, response);
	}	
	
	public void createUser(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("email");
		String fullname = request.getParameter("fullname");
		String password = request.getParameter("password");
		
		User user = new User(email, password, fullname, 19, LocalDateTime.now(), 19, LocalDateTime.now(), true);
		userDAO.create(user);
	}
}

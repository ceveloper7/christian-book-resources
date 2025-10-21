package com.sba.cbr.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import com.sba.cbr.dao.UserDAO;
import com.sba.cbr.entity.User;
import com.sba.cbr.util.Email;

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
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public UserServices(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		entityManagerFactory = Persistence.createEntityManagerFactory("cbr");
		entityManager = entityManagerFactory.createEntityManager();
		userDAO = new UserDAO(entityManager);
	}
	
	public void listUser()throws ServletException, IOException {
		listUser(null);
	}
	
	
	public void listUser(String message)throws ServletException, IOException {
		List<User> listUsers = userDAO.listAllActive();
		
		request.setAttribute("listUsers", listUsers);
		if(message != null) {
			request.setAttribute("message", "New user created successfully");
		}
		
		String listPage = "user_list.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
		requestDispatcher.forward(request, response);
	}	
	
	public void createUser() throws ServletException, IOException {
		Email email = Email.of(request.getParameter("email"));
		String fullname = request.getParameter("fullname");
		String password = request.getParameter("password");
		
		User existUser = userDAO.findByEmail(email.get());
		
		if(existUser != null) {
			String message = "Could not create user. User email " + email.get() +  " already exists";
			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request, response);
		}else {
			User user = new User(email.get(), password, fullname, 19, LocalDateTime.now(), 19, LocalDateTime.now(), true);
			userDAO.create(user);
			listUser("New user created successfully");
		}
	}
}

package com.sba.cbr.controller.admin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.sba.cbr.entity.User;
import com.sba.cbr.service.UserServices;

/**
 * Servlet implementation class ListUsersServlet
 */
@WebServlet("/admin/user_list")
public class ListUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListUsersServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserServices userServices = new UserServices();
		List<User> listUsers = userServices.listUser();
		
		request.setAttribute("listUsers", listUsers);
		
		String listPage = "user_list.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
		requestDispatcher.forward(request, response);
	}

}

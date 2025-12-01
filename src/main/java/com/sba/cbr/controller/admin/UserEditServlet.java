package com.sba.cbr.controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.sba.cbr.service.UserServices;


@WebServlet("/admin/edit_user")
public class UserEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserServices userServices = new UserServices(request, response);
		userServices.editUser();
	}

}

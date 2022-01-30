package com.onlinebookshop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinebookshop.daoimpl.UserdetailsDao;

@WebServlet("/activeuser")
public class UserActiveServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("emailid");
		
		UserdetailsDao userdetailsdao = new UserdetailsDao();
		userdetailsdao.activeUser(email);
		
		response.sendRedirect("inactiveMessage.jsp");
	
	}

}

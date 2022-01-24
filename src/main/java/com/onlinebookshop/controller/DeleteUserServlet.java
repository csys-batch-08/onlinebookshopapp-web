package com.onlinebookshop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinebookshop.daoimpl.UserdetailsDao;
import com.onlinebookshop.model.Userdetails;

/**
 * Servlet implementation class DeleteUserServlet
 */
@WebServlet("/deleteuser")
public class DeleteUserServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String email = request.getParameter("emailid");
		
		String email = request.getParameter("emailid");
		
		//Userdetails user=new Userdetails();
		
		UserdetailsDao userdetailsdao = new UserdetailsDao();
		userdetailsdao.deleteuser(email);
		
		response.sendRedirect("InactiveMessage.jsp");
	
	}

}

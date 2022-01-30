package com.onlinebookshop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinebookshop.daoimpl.UserdetailsDao;
import com.onlinebookshop.model.Userdetails;

@WebServlet("/forgotpassword")
public class ForgotPasswordServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=request.getParameter("userId");
		Long mobile =Long.parseLong(request.getParameter("mobNo"));
		String password=request.getParameter("password");
		
		Userdetails userdetails = new Userdetails(null,mobile,null,email,password,0);
		UserdetailsDao userdao = new UserdetailsDao();
		
		userdao.forgotPassword(userdetails);
		response.sendRedirect("login.jsp");
	}

}

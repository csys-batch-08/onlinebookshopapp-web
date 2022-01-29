package com.onlinebookshop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinebookshop.daoimpl.UserdetailsDao;
import com.onlinebookshop.model.Userdetails;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	    String username = request.getParameter("username");
	    
	    long phonenumber = Long.parseLong(request.getParameter("phonenumber"));
	    
	    String address = request.getParameter("address");
	    
	    String emailid = request.getParameter("email");
	    
	    String password = request.getParameter("password");
	    
	    Userdetails user = new Userdetails(username,phonenumber,address,emailid,password,0);
		
	    UserdetailsDao userdao = new UserdetailsDao();
		
	    userdao.insertUser(user);
		
		RequestDispatcher requestdispatcher = request.getRequestDispatcher("login.jsp");
		
		requestdispatcher.forward(request, response);
		
		
	}

}

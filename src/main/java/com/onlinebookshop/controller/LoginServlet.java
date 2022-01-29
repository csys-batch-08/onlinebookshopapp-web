package com.onlinebookshop.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlinebookshop.daoimpl.UserdetailsDao;
import com.onlinebookshop.model.Userdetails;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("emailid");
		String password = request.getParameter("password");
		UserdetailsDao userdao = new UserdetailsDao();
		Userdetails userdetails = userdao.validateUser(email, password);
		Userdetails admin = userdao.admin(email, password);
		
		HttpSession session=request.getSession();
		
		if(userdetails!=null)
		{
 			session.setAttribute("currentuser", userdetails);
 			
 			int userid=userdao.findUserId(email);
 			
 			session.setAttribute("userId", userid); 			
 			
 			session.setAttribute("emailid", email);
 			response.sendRedirect("ShowBookServlet");
		}
		else if(admin!=null)
		{			
 			session.setAttribute("admin", admin);
 			response.sendRedirect("admin.jsp");
 			
		}
		else
		{
			session.setAttribute("login", "Invalid User");
			response.sendRedirect("login.jsp");
			
			
		}


		
	}

}

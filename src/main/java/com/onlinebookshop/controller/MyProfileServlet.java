package com.onlinebookshop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlinebookshop.daoimpl.UserdetailsDao;
import com.onlinebookshop.model.Userdetails;


@WebServlet("/MyProfileServlet")
public class MyProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		UserdetailsDao userdetailsdao = new UserdetailsDao();
		 
		int user=(int)session.getAttribute("userId");
		
		List<Userdetails> userList = userdetailsdao.myProfile(user); 
		 
		
		request.setAttribute("userlist", userList);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("myProfile.jsp");
		requestDispatcher.forward(request, response);
				
	}

}

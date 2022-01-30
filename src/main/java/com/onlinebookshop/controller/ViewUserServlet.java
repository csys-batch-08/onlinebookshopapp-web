package com.onlinebookshop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinebookshop.daoimpl.UserdetailsDao;
import com.onlinebookshop.model.Userdetails;


@WebServlet("/ViewUserServlet")
public class ViewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserdetailsDao userdetailsdao = new UserdetailsDao();
        List<Userdetails> userList = userdetailsdao.viewUser();
	
        request.setAttribute("userlist", userList);
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("viewUser.jsp");
        
        requestDispatcher.forward(request, response);
	}

}

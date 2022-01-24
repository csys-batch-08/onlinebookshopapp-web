package com.onlinebookshop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlinebookshop.daoimpl.BookdetailsDaoimpl;


public class FilterNameServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = (String)(request.getParameter("search"));
		
		BookdetailsDaoimpl bookdao = new BookdetailsDaoimpl();
		
		HttpSession session=request.getSession();
		
		bookdao.filterName(name);
		
		session.setAttribute("Bookname", name);
		
		response.sendRedirect("FilterName.jsp");
	    
	}

}

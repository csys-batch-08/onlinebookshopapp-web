package com.onlinebookshop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlinebookshop.daoimpl.CartDaoimpl;

@WebServlet("/removecart")
public class RemoveCartServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		int bookid= Integer.parseInt(request.getParameter("bookid"));
		
	    session.setAttribute("bookid", bookid);
	   
	    int userid=(int)session.getAttribute("userId");
	    
	    CartDaoimpl cartdao = new CartDaoimpl();
	    
	    
	    cartdao.deleteCart(bookid,userid);
	    
	    RequestDispatcher requestDispatcher = request.getRequestDispatcher("ShowCartServlet");
	   
	    requestDispatcher.forward(request, response);
	}

}

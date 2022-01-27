package com.onlinebookshop.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.onlinebookshop.daoimpl.CartDaoimpl;
import com.onlinebookshop.model.Cart;

@WebServlet("/addcartserv")
public class AddCart extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		int bid= Integer.parseInt(request.getParameter("bookid"));
		
		int userId=(int) session.getAttribute("userId");
		
		CartDaoimpl cartdao = new CartDaoimpl();
		Cart cart2 = new Cart(userId,bid);
		cart2.setCusid(userId);
		session.setAttribute("itemidcart", bid);
		int cart=0;
		try {
		     cart=cartdao.insertcart(cart2);
			if(cart > 0) {
				
				session.setAttribute("cart", "Item added to cart");
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("ShowCartServlet");
				requestDispatcher.forward(request, response);
				
			}else {
				session.setAttribute("cart1", "You have already add this book in cart");
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("ShowCartServlet");
				requestDispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	

}

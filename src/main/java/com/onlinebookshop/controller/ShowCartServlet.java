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

import com.onlinebookshop.daoimpl.CartDaoimpl;
import com.onlinebookshop.daoimpl.Ratingdaoimpl;
import com.onlinebookshop.model.Cart;
import com.onlinebookshop.model.ProductDetails;


@WebServlet("/ShowCartServlet")
public class ShowCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		//int bookid = Integer.parseInt(request.getParameter("BookId"));
		
		CartDaoimpl cartDaoimpl = new CartDaoimpl();
		
		// Cart cartmodel = new  Cart();
		 
		  int cusid= (int)session.getAttribute("userId");
		 
		  List<ProductDetails> productsList =cartDaoimpl.fetchCart(cusid);
		  
		  request.setAttribute("cartList", productsList);
			
		 // System.out.println(productsList);
		  
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("ShowCart.jsp");
			requestDispatcher.forward(request, response);

		
	}

	
}

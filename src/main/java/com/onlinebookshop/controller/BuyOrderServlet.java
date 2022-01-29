package com.onlinebookshop.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlinebookshop.daoimpl.BookdetailsDaoimpl;
import com.onlinebookshop.model.ProductDetails;

@WebServlet("/BuyOrderServlet")
public class BuyOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		int bookid=Integer.parseInt(request.getParameter("bookid"));
		session.setAttribute("Book",bookid);
		BookdetailsDaoimpl bookdetailsDaoimpl = new BookdetailsDaoimpl();
		List<ProductDetails> bookdetail = bookdetailsDaoimpl.ratingproducts(bookid);
		
		request.setAttribute("orderlist", bookdetail);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("BuyOrder.jsp");
		requestDispatcher.forward(request, response);
			
	}

}

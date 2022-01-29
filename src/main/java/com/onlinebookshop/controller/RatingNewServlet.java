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


@WebServlet("/RatingNewServlet")
public class RatingNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    	@Override
    	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    		
    		int bid = Integer.parseInt(request.getParameter("bookd"));
    		
    		BookdetailsDaoimpl bookdetailsDaoimpl = new BookdetailsDaoimpl();
    		
    		List<ProductDetails> bookdetail = bookdetailsDaoimpl.ratingproducts(bid);
			
			HttpSession session = request.getSession();
			
			session.setAttribute("BookID", bid);
			
			request.setAttribute("books", bookdetail);
    		

  		    RequestDispatcher requestDispatcher = request.getRequestDispatcher("Ratings.jsp");
  		    
			requestDispatcher.forward(request, response);
    		
    		
    	}

	
}

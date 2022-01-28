package com.onlinebookshop.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlinebookshop.daoimpl.BookdetailsDaoimpl;
import com.onlinebookshop.model.Bookdetails;
import com.onlinebookshop.model.ProductDetails;


@WebServlet("/filterprice")
public class FilterPriceServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BookdetailsDaoimpl bookdao = new BookdetailsDaoimpl();
		
		int price = Integer.parseInt(request.getAttribute("filterPrice").toString());
		
		List<ProductDetails> showProduct= bookdao.filterPrice(price);
		
		request.setAttribute("filterpricelist", showProduct);
		
		HttpSession session=request.getSession();
	    
	    bookdao.filterPrice(price);
		
		session.setAttribute("filteredbook", price);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("FilterPriceProduct.jsp");
		requestDispatcher.forward(request, response);
		
		
	}

}

package com.onlinebookshop.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int price = Integer.parseInt(request.getParameter("search"));
		
		BookdetailsDaoimpl bookdao = new BookdetailsDaoimpl();
		//ProductDetails book =new ProductDetails(null, null, null, null, price, null, null, null, null,0, null);
		
		HttpSession session=request.getSession();
	    
	    bookdao.filterPrice(price);
		
		session.setAttribute("filteredbook", price);
		response.sendRedirect("FilterPriceProduct.jsp");
		
		
	}

}

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

import com.onlinebookshop.daoimpl.BookdetailsDaoimpl;
import com.onlinebookshop.model.ProductDetails;

@WebServlet("/filtername")
public class FilterNameServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session=request.getSession();
		
		String bookname = (String) session.getAttribute("Bookname");
		BookdetailsDaoimpl bookdetaildao = new BookdetailsDaoimpl();
		List<ProductDetails> showProduct= bookdetaildao.filterName(bookname);
		
		request.setAttribute("filternamelist", showProduct);
				
		String name = (request.getParameter("search"));
		if(name.matches("[a-zA-Z\s]+")) {
		BookdetailsDaoimpl bookdao = new BookdetailsDaoimpl();
		
		
		bookdao.filterName(name);
		
		session.setAttribute("Bookname", name);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("filterName.jsp");
		requestDispatcher.forward(request, response);
		
		}else {
			request.setAttribute("filterPrice", name);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("filterprice");
			requestDispatcher.forward(request, response);
		}
	    
	}

}

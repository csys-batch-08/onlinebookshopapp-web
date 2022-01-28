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


@WebServlet("/FilterByConditionServlet")
public class FilterByConditionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		int userid = (int)session.getAttribute("userId");
		BookdetailsDaoimpl bookdetaildao = new BookdetailsDaoimpl();
		List<ProductDetails> showProduct= bookdetaildao.filterCondition(userid);
		
		request.setAttribute("oldBookList", showProduct);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("FilterByCondition.jsp");
		
		requestDispatcher.forward(request, response);
		
	}

}

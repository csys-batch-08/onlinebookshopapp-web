package com.onlinebookshop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinebookshop.daoimpl.BookdetailsDaoimpl;
import com.onlinebookshop.model.ProductDetails;

@WebServlet("/ShowBookServlet")
public class ShowBookServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BookdetailsDaoimpl bookdetaildao = new BookdetailsDaoimpl();
		
		List<ProductDetails> showProduct = bookdetaildao.showProduct();

		request.setAttribute("bookList", showProduct);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("showBook.jsp");
		
		requestDispatcher.forward(request, response);

	}

}

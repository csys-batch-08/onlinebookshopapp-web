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

@WebServlet("/ShowProductServlet")
public class ShowProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int bookid = Integer.parseInt(request.getParameter("BookId"));

		request.setAttribute("bookidobj", bookid);

		BookdetailsDaoimpl bookdetaildao = new BookdetailsDaoimpl();

		List<ProductDetails> showProduct = bookdetaildao.showBook(bookid);

		request.setAttribute("booklist", showProduct);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("showProduct.jsp");

		requestDispatcher.forward(request, response);
	}

}

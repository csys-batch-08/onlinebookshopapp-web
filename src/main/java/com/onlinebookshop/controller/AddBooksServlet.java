package com.onlinebookshop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinebookshop.daoimpl.BookdetailsDaoimpl;
import com.onlinebookshop.model.Bookdetails;

@WebServlet("/AddBooks")
public class AddBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BookdetailsDaoimpl bookDao = new BookdetailsDaoimpl();
		String category =request.getParameter("category");
		String description =request.getParameter("description");
		String booktitle =request.getParameter("booktitle");
		String bookcode =request.getParameter("bookcode");
		Integer price =Integer.parseInt(request.getParameter("price"));
		String date =request.getParameter("publishdate");
		LocalDate publishdate = LocalDate.parse(date);
		String condition =request.getParameter("condition");
		String image = request.getParameter("image");
		Bookdetails bookdetails = new Bookdetails(category,description,booktitle,bookcode,price,publishdate,condition,image);
		bookDao.insertBooks(bookdetails);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("ViewAllBookServlet");
		
		requestDispatcher.forward(request, response);
	}

}

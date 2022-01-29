package com.onlinebookshop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinebookshop.daoimpl.BookdetailsDaoimpl;
import com.onlinebookshop.model.Bookdetails;


@WebServlet("/updatebook")
public class UpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String booktitle =request.getParameter("booktitle");
		
		int price =Integer.parseInt(request.getParameter("price"));
		
		Bookdetails bookdetails = new Bookdetails(null,null,booktitle,null,price,null,null,null);
		
		BookdetailsDaoimpl bookDao = new BookdetailsDaoimpl();
		
		bookDao.updateBooks(bookdetails);
		
	}

}

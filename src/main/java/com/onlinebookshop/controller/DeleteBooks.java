package com.onlinebookshop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinebookshop.daoimpl.BookdetailsDaoimpl;


@WebServlet("/DeleteBooks")
public class DeleteBooks extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		
		//String bookname = request.getParameter("booktitle");
		
		int bookid =Integer.parseInt(request.getParameter("bookid"));
		System.out.println(bookid);
		BookdetailsDaoimpl bookDao = new BookdetailsDaoimpl();
		bookDao.deleteBooks(bookid);
		//doGet(request, response);
	}

}

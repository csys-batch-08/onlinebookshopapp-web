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
import com.onlinebookshop.model.Bookdetails;


@WebServlet("/ViewAllBookServlet")
public class ViewAllBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BookdetailsDaoimpl bookdetailsdao = new BookdetailsDaoimpl();
		
        List<Bookdetails> bookList = bookdetailsdao.viewAllBook();
        
        request.setAttribute("viewAllBook", bookList);
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("viewAllBook.jsp");
        
        requestDispatcher.forward(request, response);
        
	}

}

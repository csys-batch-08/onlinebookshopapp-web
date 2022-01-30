package com.onlinebookshop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.onlinebookshop.daoimpl.AuthorDetailsDaoimpl;
import com.onlinebookshop.daoimpl.BookdetailsDaoimpl;
import com.onlinebookshop.model.AuthorDetails;



@WebServlet("/AddAuthor")
public class AddAuthorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String authorname =request.getParameter("authorname");
		
		String email = request.getParameter("email");
		
		String bname = request.getParameter("bookname");
		
		BookdetailsDaoimpl bookdetailsDaoimpl = new BookdetailsDaoimpl();
		
		int bid = bookdetailsDaoimpl.findProductid(bname);
		
		AuthorDetails author = new AuthorDetails(authorname,email,bid);
		
		AuthorDetailsDaoimpl authordao = new AuthorDetailsDaoimpl();
		
		authordao.insertAuthor(author);
		
		request.setAttribute("addauthor", "Author added sucessfully");
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("ViewAuthorServlet");
		
		requestDispatcher.forward(request, response);
		
	}

}

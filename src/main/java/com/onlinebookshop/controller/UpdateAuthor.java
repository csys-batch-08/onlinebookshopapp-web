package com.onlinebookshop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinebookshop.daoimpl.AuthorDetailsDaoimpl;


@WebServlet("/updateauthor")
public class UpdateAuthor extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
          String authoremail = request.getParameter("emailid");
          String authorname = request.getParameter("authorname");
          
          AuthorDetailsDaoimpl authordao = new AuthorDetailsDaoimpl();
          authordao.updateAuthor(authoremail, authorname);
     
          response.sendRedirect("viewAuthor.jsp");
		
	}

}

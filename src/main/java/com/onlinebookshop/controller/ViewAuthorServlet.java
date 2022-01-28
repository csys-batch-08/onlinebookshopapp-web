package com.onlinebookshop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinebookshop.daoimpl.AuthorDetailsDaoimpl;
import com.onlinebookshop.model.AuthorDetails;


@WebServlet("/ViewAuthorServlet")
public class ViewAuthorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AuthorDetailsDaoimpl authordao = new AuthorDetailsDaoimpl();
        List<AuthorDetails> authorList = new ArrayList<AuthorDetails>();
        authorList = authordao.showAuthor();
        
        request.setAttribute("authorlist", authorList);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("ViewAuthor.jsp");
		requestDispatcher.forward(request, response);
	}

}

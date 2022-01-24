package com.onlinebookshop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinebookshop.daoimpl.AuthorDetailsDaoimpl;
import com.onlinebookshop.model.AuthorDetails;

/**
 * Servlet implementation class UpdateAuthor
 */
@WebServlet("/updateauthor")
public class UpdateAuthor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAuthor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
          String authoremail = request.getParameter("emailid");
          String authorname = request.getParameter("authorname");
          
          AuthorDetails author = new AuthorDetails(authorname,authoremail,0);
          AuthorDetailsDaoimpl authordao = new AuthorDetailsDaoimpl();
          authordao.updateAuthor(authoremail, authorname);
     
          response.sendRedirect("ViewAuthor.jsp");
		//doGet(request, response);
	}

}

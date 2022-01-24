package com.onlinebookshop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlinebookshop.daoimpl.AuthorDetailsDaoimpl;
import com.onlinebookshop.daoimpl.BookdetailsDaoimpl;
import com.onlinebookshop.model.AuthorDetails;


/**
 * Servlet implementation class AddAuthorServlet
 */
@WebServlet("/AddAuthor")
public class AddAuthorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAuthorServlet() {
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
		
		HttpSession session = request.getSession();
		String authorname =request.getParameter("authorname");
		String email = request.getParameter("email");
		String bname = request.getParameter("bookname");
		BookdetailsDaoimpl bookdetailsDaoimpl = new BookdetailsDaoimpl();
		int bid = bookdetailsDaoimpl.findProductid(bname);
		
		//System.out.println(email);
		
		AuthorDetails author = new AuthorDetails(authorname,email,bid);
		AuthorDetailsDaoimpl authordao = new AuthorDetailsDaoimpl();
		authordao.insertAuthor(author);
		
		request.setAttribute("addauthor", "Author added sucessfully");
		response.sendRedirect("ViewAuthor.jsp");
		
	}

}

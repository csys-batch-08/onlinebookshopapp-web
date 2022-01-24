package com.onlinebookshop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinebookshop.daoimpl.UserdetailsDao;
import com.onlinebookshop.model.Userdetails;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	    String username = request.getParameter("username");
	    long phonenumber = Long.parseLong(request.getParameter("phonenumber"));
	    String address = request.getParameter("address");
	    String emailid = request.getParameter("email");
	    String password = request.getParameter("password");
	    
	    Userdetails user = new Userdetails(username,phonenumber,address,emailid,password,0);
		UserdetailsDao userdao = new UserdetailsDao();
		userdao.insertUser(user);
		
		RequestDispatcher requestdispatcher = request.getRequestDispatcher("login.jsp");
		requestdispatcher.forward(request, response);
		//doGet(request, response);
		
	}

}

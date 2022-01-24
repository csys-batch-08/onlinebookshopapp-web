package com.onlinebookshop.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlinebookshop.daoimpl.UserdetailsDao;
import com.onlinebookshop.model.Userdetails;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("emailid");
		String password = request.getParameter("password");
		UserdetailsDao userdao = new UserdetailsDao();
		Userdetails user = userdao.validateUser(email, password);
		Userdetails admin = userdao.admin(email, password);
		PrintWriter pw = response.getWriter();
		if(user!=null)
		{
//           RequestDispatcher rd = request.getRequestDispatcher("ShowProduct.jsp");
//             rd.forward(request, response);
             
			HttpSession session=request.getSession();
 			session.setAttribute("currentuser", user);
 			
 			int userid=userdao.findUserId(email);
 			//System.out.println(userid);
 			
 			session.setAttribute("userId", userid);
 			//System.out.println("userId"+userid);
 			
 			
 			session.setAttribute("emailid", email);
 			response.sendRedirect("ShowBook.jsp");
		}
		else if(admin!=null)
		{
//			RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
//			rd.forward(request, response);
			
			HttpSession session=request.getSession();
 			session.setAttribute("admin", admin);
 			response.sendRedirect("admin.jsp");
 			
		}
		else
		{
			pw.write("Invalid login");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			
			
		}


		//doGet(request, response);
	}

}

package com.onlinebookshop.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlinebookshop.daoimpl.BookdetailsDaoimpl;
import com.onlinebookshop.daoimpl.Ratingdaoimpl;
import com.onlinebookshop.model.Rating;

@WebServlet("/rating")
public class RatingServlet extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		int userid= (int)session.getAttribute("userId");

		int ID = (int) session.getAttribute("BookID");		
		
		int rating = Integer.parseInt(request.getParameter("ratings"));
		
		Rating rate=new Rating(userid,ID,rating);
		
		Ratingdaoimpl ratingdao = new Ratingdaoimpl();
		
		try {
			int res = ratingdao.insertrating(rate);
			System.out.println(res);
			if(res > 0) {
				response.sendRedirect("ShowBook.jsp");
			}else {
				response.sendRedirect("AlreadyRating.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

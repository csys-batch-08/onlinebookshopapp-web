package com.onlinebookshop.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.onlinebookshop.daoimpl.CartDaoimpl;
import com.onlinebookshop.model.Cart;

@WebServlet("/addcartserv")
public class AddCart extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		int bid= Integer.parseInt(request.getParameter("bookid"));
		
    	//System.out.println("bid"+bid);
		
		
		int userId=(int) session.getAttribute("userId");
		
        //System.out.println(userId);
		
		
		CartDaoimpl cartdao = new CartDaoimpl();
		Cart cart2 = new Cart(userId,bid);
		cart2.setCus_id(userId);
		session.setAttribute("itemidcart", bid);
		try {
			int cart=cartdao.insertcart(cart2);
			if(cart > 0) {
				response.sendRedirect("cartsuccess.jsp");
			}else {
				response.getWriter().println("You have already add this book in cart");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}

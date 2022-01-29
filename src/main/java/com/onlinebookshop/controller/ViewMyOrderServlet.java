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
import javax.servlet.http.HttpSession;

import com.onlinebookshop.daoimpl.OrderDetailsDaoimpl;
import com.onlinebookshop.model.OrderDetails;


@WebServlet("/ViewMyOrderServlet")
public class ViewMyOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		int userid = (int) session.getAttribute("userId");
		
        OrderDetailsDaoimpl orderdao = new OrderDetailsDaoimpl();
        
        List<OrderDetails> orderList = orderdao.viewUserOrder(userid);
        
        request.setAttribute("viewOrderList", orderList);
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("ViewMyOrders.jsp");
        
        requestDispatcher.forward(request, response);
        
	}

}

package com.onlinebookshop.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinebookshop.daoimpl.OrderDetailsDaoimpl;
import com.onlinebookshop.model.OrderDetails;

@WebServlet("/FilterOrderServlet")
public class FilterOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String date = request.getParameter("search");
		
//		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 
//		 
//		 String strDate= formatter.format(date); 
//		 
//		System.out.println(strDate);
		OrderDetailsDaoimpl orderDetailsDaoimpl = new OrderDetailsDaoimpl();
		
        List<OrderDetails> orderList = orderDetailsDaoimpl.filterOrderDate(date);
        
		request.setAttribute("orderlist", orderList);
		
		System.out.println(orderList);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("viewAllOrders.jsp");
		requestDispatcher.forward(request, response);
	}

}

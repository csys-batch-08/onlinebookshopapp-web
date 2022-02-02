package com.onlinebookshop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlinebookshop.daoimpl.OrderDetailsDaoimpl;
import com.onlinebookshop.daoimpl.UserdetailsDao;
import com.onlinebookshop.model.Userdetails;

@WebServlet("/cancelorder")
public class OrderCancelServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		int orderId =Integer.parseInt(request.getParameter("orderid"));
				
		OrderDetailsDaoimpl orderdetails = new OrderDetailsDaoimpl();
		
		String status=orderdetails.findStatus(orderId);
		
		if(status.equals("order canceled")) {
			
			response.sendRedirect("alreadyCancel.jsp");
			
		}else {
			
            orderdetails.cancelOrder(orderId);
			
			int totalAmount =orderdetails.findOrderPrice(orderId);
			
			UserdetailsDao userdao = new UserdetailsDao();

			int userid = (int)session.getAttribute("userId");
			
			int wallet = userdao.walletballance(userid);
		
				int refund = wallet + totalAmount;
				
				session.setAttribute("availbalance", refund);
				
				String email=(String) session.getAttribute("emailid");
				
				Userdetails updatewallet = new Userdetails(null,0,null,email,null,refund);
				
				userdao.updatewallet(updatewallet);
				
				
				
				response.sendRedirect("orderCancel.jsp");
			
		}
		
		
		
		
		    
	}

}

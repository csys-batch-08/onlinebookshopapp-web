package com.onlinebookshop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlinebookshop.daoimpl.BookdetailsDaoimpl;
import com.onlinebookshop.daoimpl.OrderDetailsDaoimpl;
import com.onlinebookshop.daoimpl.UserdetailsDao;
import com.onlinebookshop.model.OrderDetails;
import com.onlinebookshop.model.Userdetails;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		int quantity = Integer.parseInt(request.getParameter("quantity"));

		int userid = Integer.parseInt(session.getAttribute("userId").toString());

		String userName = (String) session.getAttribute("emailid");
		
		int itemid = (int) session.getAttribute("Book");

		BookdetailsDaoimpl bookdetails = new BookdetailsDaoimpl();

		int price = bookdetails.findPrice(itemid);

		int totalprice = quantity * price;
        
		session.setAttribute("Totalprice", totalprice);
		
		OrderDetailsDaoimpl orderDao = new OrderDetailsDaoimpl();

		OrderDetails orderBook = new OrderDetails(itemid, userid, quantity, totalprice);

		
		
		UserdetailsDao userdao = new UserdetailsDao();

		int wallet = userdao.walletballance(userid);

		session.setAttribute("availwallet", wallet);
		
		if (wallet > totalprice) {
            
			orderDao.insertOrder(orderBook);
			
			int newWallet = wallet - totalprice;

			session.setAttribute("newwallet", newWallet);
			
			Userdetails user = new Userdetails(null, 0, null, userName, null, newWallet);

			userdao.updatewallet(user);

			response.sendRedirect("ordermsg.jsp");

		} else {
			response.sendRedirect("lowBalance.jsp");
		}
	}

}

package com.onlinebookshop.dao;

import java.util.List;


import com.onlinebookshop.model.OrderDetails;


public interface OrderDetailsDao {

	public void insertOrder(OrderDetails cart);
	public List<OrderDetails> viewOrder();
	public int updateOrder(int quantity,int bookid);
	public int cancelOrder(int orderid);
	public List<OrderDetails> viewUserOrder(int userid);
}

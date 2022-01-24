package com.onlinebookshop.dao;

import java.sql.ResultSet;
import java.util.List;

import com.onlinebookshop.model.Bookdetails;
import com.onlinebookshop.model.OrderDetails;
import com.onlinebookshop.model.Userdetails;

public interface OrderDetailsDao {

	public void insertOrder(OrderDetails cart);
	public List<OrderDetails> viewOrder();
	public int updateOrder(int quantity,int book_id);
	public int cancelOrder(int orderid);
	public List<OrderDetails> viewUserOrder(int userid);
}

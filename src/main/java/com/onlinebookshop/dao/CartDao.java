package com.onlinebookshop.dao;

import java.sql.SQLException;

import com.onlinebookshop.model.Cart;

public interface CartDao {

	public int insertcart(Cart cart) throws SQLException;
	
}

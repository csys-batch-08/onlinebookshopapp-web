package com.onlinebookshop.dao;

import java.sql.ResultSet;
import java.util.List;

import com.onlinebookshop.model.Bookdetails;
import com.onlinebookshop.model.ProductDetails;

public interface BookdetailsDao {

	public int insertBooks(Bookdetails product);
	public void deleteBooks(int product);
	public List<ProductDetails> showProduct();
	public int findProductid(String book_title);
	public int findPrice(int proid);
	public void updateBooks(Bookdetails bookdetails);
	public List<ProductDetails> filterPrice(int price);
	public List<ProductDetails> filterCondition(int userid);
}

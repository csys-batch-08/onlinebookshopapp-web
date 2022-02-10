package com.onlinebookshop.dao;

import java.util.List;

import com.onlinebookshop.model.Bookdetails;
import com.onlinebookshop.model.ProductDetails;

public interface BookdetailsDao {

	public int insertBooks(Bookdetails product);
	public void deleteBooks(int product);
	public List<ProductDetails> showProduct();
	public List<ProductDetails> showBook(int bookId);
	public int findProductid(String bookTitle);
	public String findBookname(int bookId);
	public int findPrice(int productId);
	public void updateBooks(Bookdetails bookDetails);
	public List<ProductDetails> filterPrice(int price);
	public List<ProductDetails> filterName(String bookTitle);
	public List<ProductDetails> filterCondition();
	public List<Bookdetails> categoryList();
	public List<Bookdetails> viewAllBook();
	public List<ProductDetails> ratingproducts(int bookId);
}

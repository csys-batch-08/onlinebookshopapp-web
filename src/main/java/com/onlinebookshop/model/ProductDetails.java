package com.onlinebookshop.model;

import java.time.LocalDate;
import java.util.Objects;

public class ProductDetails {

	private int bookid;
	private String category;
	private String description;
	private String book_title;
	private String book_code;
	private int price;
	private LocalDate publish_date;
	private String condition;
	private String name;
	private String email_id;
	private int rating;
	private String bookimages;
	private String status;
	
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int book_id) {
		this.bookid = book_id;
	}
	public String getBookimages() {
		return bookimages;
	}
	public void setBookimages(String bookimages) {
		this.bookimages = bookimages;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBook_title() {
		return book_title;
	}
	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}
	public String getBook_code() {
		return book_code;
	}
	public void setBook_code(String book_code) {
		this.book_code = book_code;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public LocalDate getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(LocalDate publish_date) {
		this.publish_date = publish_date;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public ProductDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductDetails(int bookid,String category, String description, String book_title, String book_code, int price,
			LocalDate publish_date, String condition, String name, String email_id, int rating,String bookimages) {
		super();
		this.bookid = bookid;
		this.category = category;
		this.description = description;
		this.book_title = book_title;
		this.book_code = book_code;
		this.price = price;
		this.publish_date = publish_date;
		this.condition = condition;
		this.name = name;
		this.email_id = email_id;
		this.rating = rating;
		this.bookimages = bookimages;
	}
	
	public ProductDetails(String category, String description, String book_title, String book_code, int price,
			LocalDate publish_date, String condition, String name, String email_id, int rating,String bookimages) {
		super();
		
		this.category = category;
		this.description = description;
		this.book_title = book_title;
		this.book_code = book_code;
		this.price = price;
		this.publish_date = publish_date;
		this.condition = condition;
		this.name = name;
		this.email_id = email_id;
		this.rating = rating;
		this.bookimages = bookimages;
	}
	@Override
	public String toString() {
		return "ShowProduct [category=" + category + ", description=" + description + ", book_title=" + book_title
				+ ", book_code=" + book_code + ", price=" + price + ", publish_date=" + publish_date + ", condition="
				+ condition + ", name=" + name + ", email_id=" + email_id + ", rating=" + rating + ", bookimages=" + bookimages + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(book_code, book_title, bookimages, category, condition, description, email_id, name, price,
				publish_date, rating);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductDetails other = (ProductDetails) obj;
		return Objects.equals(book_code, other.book_code) && Objects.equals(book_title, other.book_title)
				&& Objects.equals(category, other.category) && Objects.equals(condition, other.condition)
				&& Objects.equals(description, other.description) && Objects.equals(email_id, other.email_id)
				&& Objects.equals(name, other.name) && price == other.price
				&& Objects.equals(publish_date, other.publish_date) && rating == other.rating
						&& Objects.equals(bookimages, other.bookimages);
	}
	
	

}

package com.onlinebookshop.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class ProductDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int bookId;
	private String category;
	private String description;
	private String bookTitle;
	private String bookCode;
	private int price;
	private LocalDate publishDate;
	private String condition;
	private String name;
	private String emailId;
	private double rating;
	private String bookImages;
	private String status;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookImages() {
		return bookImages;
	}

	public void setBookImages(String bookImages) {
		this.bookImages = bookImages;
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

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookCode() {
		return bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishdate(LocalDate publishDate) {
		this.publishDate = publishDate;
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
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
	}

	public ProductDetails(int bookId, String category, String description, String bookTitle, String bookCode, int price,
			LocalDate publishDate, String condition, String name, String emailId, double rating, String bookImages) {
		super();
		this.bookId = bookId;
		this.category = category;
		this.description = description;
		this.bookTitle = bookTitle;
		this.bookCode = bookCode;
		this.price = price;
		this.publishDate = publishDate;
		this.condition = condition;
		this.name = name;
		this.emailId = emailId;
		this.rating = rating;
		this.bookImages = bookImages;
	}

	public ProductDetails(String category, String description, String bookTitle, String bookCode, int price,
			LocalDate publishDate, String condition, String name, String emailId, double rating, String bookImages) {
		super();

		this.category = category;
		this.description = description;
		this.bookTitle = bookTitle;
		this.bookCode = bookCode;
		this.price = price;
		this.publishDate = publishDate;
		this.condition = condition;
		this.name = name;
		this.emailId = emailId;
		this.rating = rating;
		this.bookImages = bookImages;
	}

	@Override
	public String toString() {
		return "ShowProduct [category=" + category + ", description=" + description + ", bookTitle=" + bookTitle
				+ ", bookCode=" + bookCode + ", price=" + price + ", publishDate=" + publishDate + ", condition="
				+ condition + ", name=" + name + ", emailId=" + emailId + ", rating=" + rating + ", bookImages="
				+ bookImages + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookCode, bookId, bookImages, bookTitle, category, condition, description, emailId, name,
				price, publishDate, rating, status);
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
		return Objects.equals(bookCode, other.bookCode) && bookId == other.bookId
				&& Objects.equals(bookImages, other.bookImages) && Objects.equals(bookTitle, other.bookTitle)
				&& Objects.equals(category, other.category) && Objects.equals(condition, other.condition)
				&& Objects.equals(description, other.description) && Objects.equals(emailId, other.emailId)
				&& Objects.equals(name, other.name) && price == other.price
				&& Objects.equals(publishDate, other.publishDate)
				&& Double.doubleToLongBits(rating) == Double.doubleToLongBits(other.rating)
				&& Objects.equals(status, other.status);
	}

}

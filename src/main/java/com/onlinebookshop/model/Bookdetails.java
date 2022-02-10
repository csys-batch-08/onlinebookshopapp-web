package com.onlinebookshop.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Bookdetails implements Serializable {

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
	private String bookImages;
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public int getBookId() {
		return this.bookId;
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

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getBookImages() {
		return bookImages;
	}

	public void setBookImages(String bookImages) {
		this.bookImages = bookImages;
	}

	public Bookdetails() {
		super();
	}

	public Bookdetails(String category, String description, String bookTitle, String bookCode, int price,
			LocalDate publishDate, String condition, String bookImages) {
		super();
		this.category = category;
		this.description = description;
		this.bookTitle = bookTitle;
		this.bookCode = bookCode;
		this.price = price;
		this.publishDate = publishDate;
		this.condition = condition;
		this.bookImages = bookImages;
	}

	public Bookdetails(int bookId, String category, String description, String bookTitle, String bookCode, int price,
			LocalDate publishDate, String condition, String bookImages) {
		super();
		this.bookId = bookId;
		this.category = category;
		this.description = description;
		this.bookTitle = bookTitle;
		this.bookCode = bookCode;
		this.price = price;
		this.publishDate = publishDate;
		this.condition = condition;
		this.bookImages = bookImages;
	}

	public Bookdetails(int bookId, String category, String description, String bookTitle, String bookCode, int price,
			LocalDate publishDate, String condition, String bookImages, String status) {
		super();
		this.bookId = bookId;
		this.category = category;
		this.description = description;
		this.bookTitle = bookTitle;
		this.bookCode = bookCode;
		this.price = price;
		this.publishDate = publishDate;
		this.condition = condition;
		this.bookImages = bookImages;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Bookdetails [bookId=" + bookId + ", category=" + category + ", description=" + description
				+ ", bookTitle=" + bookTitle + ", bookCode=" + bookCode + ", price=" + price + ", publishDate="
				+ publishDate + ", condition=" + condition + ", bookImages=" + bookImages + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookCode, bookTitle, bookImages, category, condition, description, price, publishDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bookdetails other = (Bookdetails) obj;
		return Objects.equals(bookCode, other.bookCode) && Objects.equals(bookTitle, other.bookTitle)
				&& Objects.equals(bookImages, other.bookImages) && Objects.equals(category, other.category)
				&& Objects.equals(condition, other.condition) && Objects.equals(description, other.description)
				&& price == other.price && Objects.equals(publishDate, other.publishDate);
	}

}

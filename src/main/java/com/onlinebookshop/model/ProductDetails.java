package com.onlinebookshop.model;

import java.time.LocalDate;
import java.util.Objects;

public class ProductDetails {

	private int bookid;
	private String category;
	private String description;
	private String booktitle;
	private String bookcode;
	private int price;
	private LocalDate publishdate;
	private String condition;
	private String name;
	private String emailid;
	private double rating;
	private String bookimages;
	private String status;

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
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

	public String getBooktitle() {
		return booktitle;
	}

	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}

	public String getBookcode() {
		return bookcode;
	}

	public void setBookcode(String bookcode) {
		this.bookcode = bookcode;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public LocalDate getPublishdate() {
		return publishdate;
	}

	public void setPublishdate(LocalDate publishdate) {
		this.publishdate = publishdate;
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

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
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

	public ProductDetails(int bookid, String category, String description, String booktitle, String bookcode, int price,
			LocalDate publishdate, String condition, String name, String emailid, double rating, String bookimages) {
		super();
		this.bookid = bookid;
		this.category = category;
		this.description = description;
		this.booktitle = booktitle;
		this.bookcode = bookcode;
		this.price = price;
		this.publishdate = publishdate;
		this.condition = condition;
		this.name = name;
		this.emailid = emailid;
		this.rating = rating;
		this.bookimages = bookimages;
	}

	public ProductDetails(String category, String description, String booktitle, String bookcode, int price,
			LocalDate publishdate, String condition, String name, String emailid, double rating, String bookimages) {
		super();

		this.category = category;
		this.description = description;
		this.booktitle = booktitle;
		this.bookcode = bookcode;
		this.price = price;
		this.publishdate = publishdate;
		this.condition = condition;
		this.name = name;
		this.emailid = emailid;
		this.rating = rating;
		this.bookimages = bookimages;
	}

	@Override
	public String toString() {
		return "ShowProduct [category=" + category + ", description=" + description + ", booktitle=" + booktitle
				+ ", bookcode=" + bookcode + ", price=" + price + ", publishdate=" + publishdate + ", condition="
				+ condition + ", name=" + name + ", emailid=" + emailid + ", rating=" + rating + ", bookimages="
				+ bookimages + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookcode, booktitle, bookimages, category, condition, description, emailid, name, price,
				publishdate, rating);
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
		return Objects.equals(bookcode, other.bookcode) && Objects.equals(booktitle, other.booktitle)
				&& Objects.equals(category, other.category) && Objects.equals(condition, other.condition)
				&& Objects.equals(description, other.description) && Objects.equals(emailid, other.emailid)
				&& Objects.equals(name, other.name) && price == other.price
				&& Objects.equals(publishdate, other.publishdate) && rating == other.rating
				&& Objects.equals(bookimages, other.bookimages);
	}

}

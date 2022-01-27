package com.onlinebookshop.model;

 import java.time.LocalDate;
import java.util.Objects;

public class Bookdetails {

	private int bookid;
	private String category;
	private String description;
	private String booktitle;
	private String bookcode;
	private int price;
	private LocalDate publishdate;
	private String condition;
	private String bookimages;
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
	public String getBooktitle() {
		return booktitle;
	}
	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}
	public String getBookcode() {
		return bookcode;
	}
	public int getBookid() {
		return this.bookid;
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
	public void setBookid(int bookid) {
		this.bookid = bookid;
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
	public String getBookimages() {
		return bookimages;
	}
	public void setBookimages(String bookimages) {
		this.bookimages = bookimages;
	}
	public Bookdetails() {
		super();
	}
	public Bookdetails(String category, String description, String booktitle, String bookcode, int price,
			LocalDate publishdate, String condition, String bookimages) {
		super();
		this.category = category;
		this.description = description;
		this.booktitle = booktitle;
		this.bookcode = bookcode;
		this.price = price;
		this.publishdate = publishdate;
		this.condition = condition;
		this.bookimages = bookimages;
	}
	public Bookdetails(int bookid, String category, String description, String booktitle, String bookcode, int price,
			LocalDate publishdate, String condition, String bookimages) {
		super();
		this.bookid = bookid;
		this.category = category;
		this.description = description;
		this.booktitle = booktitle;
		this.bookcode = bookcode;
		this.price = price;
		this.publishdate = publishdate;
		this.condition = condition;
		this.bookimages = bookimages;
	}
	
	public Bookdetails(int bookid, String category, String description, String booktitle, String bookcode, int price,
			LocalDate publishdate, String condition, String bookimages, String status) {
		super();
		this.bookid = bookid;
		this.category = category;
		this.description = description;
		this.booktitle = booktitle;
		this.bookcode = bookcode;
		this.price = price;
		this.publishdate = publishdate;
		this.condition = condition;
		this.bookimages = bookimages;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Bookdetails [category=" + category + ", description=" + description + ", booktitle=" + booktitle
				+ ", bookcode=" + bookcode + ", price=" + price + ", publishdate=" + publishdate + ", condition="
				+ condition + ", bookimages=" + bookimages + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(bookcode, booktitle, bookimages, category, condition, description, price, publishdate);
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
		return Objects.equals(bookcode, other.bookcode) && Objects.equals(booktitle, other.booktitle)
				&& Objects.equals(bookimages, other.bookimages) && Objects.equals(category, other.category)
				&& Objects.equals(condition, other.condition) && Objects.equals(description, other.description)
				&& price == other.price && Objects.equals(publishdate, other.publishdate);
	}
	
	
	
	
}

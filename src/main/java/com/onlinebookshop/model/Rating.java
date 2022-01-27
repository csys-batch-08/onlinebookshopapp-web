package com.onlinebookshop.model;

public class Rating {

	private int id;
	private int cusid;
	private int bookid;
	private double rating;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCusid() {
		return cusid;
	}
	public void setCusid(int cusid) {
		this.cusid = cusid;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public Rating(int id, int cusid, int bookid, double rating) {
		super();
		this.id = id;
		this.cusid = cusid;
		this.bookid = bookid;
		this.rating = rating;
	}
	public Rating(int cusid, int bookid, double rating) {
		super();
		this.cusid = cusid;
		this.bookid = bookid;
		this.rating = rating;
	}
	public Rating(int bookid) {
		super();
		
		this.bookid = bookid;
		
	}
	public Rating() {
		super();

	}
	@Override
	public String toString() {
		return "Rating [id=" + id + ", cusid=" + cusid + ", bookid=" + bookid + ", rating=" + rating + "]";
	}
	
}

package com.onlinebookshop.model;

import java.io.Serializable;

public class Rating implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int cusid;
	private int bookid;
	private double ratings;

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
		return ratings;
	}

	public void setRating(double ratings) {
		this.ratings = ratings;
	}

	public Rating(int id, int cusid, int bookid, double ratings) {
		super();
		this.id = id;
		this.cusid = cusid;
		this.bookid = bookid;
		this.ratings = ratings;
	}

	public Rating(int cusid, int bookid, double ratings) {
		super();
		this.cusid = cusid;
		this.bookid = bookid;
		this.ratings = ratings;
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
		return "Rating [id=" + id + ", cusid=" + cusid + ", bookid=" + bookid + ", ratings=" + ratings + "]";
	}

}

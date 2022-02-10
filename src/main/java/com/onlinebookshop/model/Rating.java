package com.onlinebookshop.model;

import java.io.Serializable;

public class Rating implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private int cusId;
	private int bookId;
	private double ratings;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCusId() {
		return cusId;
	}

	public void setCusId(int cusId) {
		this.cusId = cusId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public double getRating() {
		return ratings;
	}

	public void setRating(double ratings) {
		this.ratings = ratings;
	}

	public Rating(int id, int cusId, int bookId, double ratings) {
		super();
		this.id = id;
		this.cusId = cusId;
		this.bookId = bookId;
		this.ratings = ratings;
	}

	public Rating(int cusId, int bookID, double ratings) {
		super();
		this.cusId = cusId;
		this.bookId = bookID;
		this.ratings = ratings;
	}

	public Rating(int bookId) {
		super();

		this.bookId = bookId;

	}

	public Rating() {
		super();

	}

	@Override
	public String toString() {
		return "Rating [id=" + id + ", cusId=" + cusId + ", bookId=" + bookId + ", ratings=" + ratings + "]";
	}

}

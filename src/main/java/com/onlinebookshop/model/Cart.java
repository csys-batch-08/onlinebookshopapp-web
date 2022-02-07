package com.onlinebookshop.model;

import java.io.Serializable;
import java.util.Objects;

public class Cart implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int cartid;
	private int bookid;
	private int cusid;

	public Cart(int cartid, int bookid, int cusid) {
		super();
		this.cartid = cartid;
		this.bookid = bookid;
		this.cusid = cusid;
	}

	public int getCusid() {
		return cusid;
	}

	public void setCusid(int cusid) {
		this.cusid = cusid;
	}

	public int getCartid() {
		return cartid;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public Cart(int cartid, int bookid) {
		super();
		this.cartid = cartid;
		this.bookid = bookid;
	}

	public Cart(int bookid) {

		this.bookid = bookid;
	}

	public Cart() {
		super();
	}

	@Override
	public String toString() {
		return "Cart [cartid=" + cartid + ", bookid=" + bookid + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookid, cartid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		return bookid == other.bookid && cartid == other.cartid;
	}

}

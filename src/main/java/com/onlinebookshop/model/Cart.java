package com.onlinebookshop.model;

import java.io.Serializable;
import java.util.Objects;

public class Cart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int cartId;
	private int bookId;
	private int cusId;

	public Cart(int cartId, int bookId, int cusId) {
		super();
		this.cartId = cartId;
		this.bookId = bookId;
		this.cusId = cusId;
	}

	public int getCusId() {
		return cusId;
	}

	public void setCusId(int cusId) {
		this.cusId = cusId;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public Cart(int cartId, int bookId) {
		super();
		this.cartId = cartId;
		this.bookId = bookId;
	}

	public Cart(int bookId) {

		this.bookId = bookId;
	}

	public Cart() {
		super();
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", bookId=" + bookId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookId, cartId);
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
		return bookId == other.bookId && cartId == other.cartId;
	}

}

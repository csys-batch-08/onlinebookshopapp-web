package com.onlinebookshop.model;

import java.util.Objects;

public class Cart {

	private int cart_id;
	private int book_id;
	private int cus_id;
	
	
	
	public Cart(int cart_id, int book_id, int cus_id) {
		super();
		this.cart_id = cart_id;
		this.book_id = book_id;
		this.cus_id = cus_id;
	}
	public int getCus_id() {
		return cus_id;
	}
	public void setCus_id(int cus_id) {
		this.cus_id = cus_id;
	}
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public Cart(int cart_id, int book_id) {
		super();
		this.cart_id = cart_id;
		this.book_id = book_id;
	}
	public Cart(int book_id) {
		
		this.book_id = book_id;
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Cart [cart_id=" + cart_id + ", book_id=" + book_id + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(book_id, cart_id);
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
		return book_id == other.book_id && cart_id == other.cart_id;
	}
	
	
}

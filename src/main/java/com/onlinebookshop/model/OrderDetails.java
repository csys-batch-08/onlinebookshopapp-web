package com.onlinebookshop.model;

import java.time.LocalDate;
import java.util.Objects;

public class OrderDetails {

	private int orderid;
	private int bookid;
	private int cusid;
	private int quantity;
	private double totalcost;
	private LocalDate orderdate;
	private String status;

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public int getCusid() {
		return cusid;
	}

	public void setCusid(int cusid) {
		this.cusid = cusid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalcost() {
		return totalcost;
	}

	public void setTotalcost(double totalcost) {
		this.totalcost = totalcost;
	}

	public LocalDate getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(LocalDate orderdate) {
		this.orderdate = orderdate;
	}

	public OrderDetails() {
		super();

	}

	public OrderDetails(int bookid, int cusid, int quantity, double totalcost) {
		super();
		this.bookid = bookid;
		this.cusid = cusid;
		this.quantity = quantity;
		this.totalcost = totalcost;
	}

	public OrderDetails(int bookid, int cusid, int quantity, double totalcost, LocalDate orderdate, String status) {
		super();
		this.bookid = bookid;
		this.cusid = cusid;
		this.quantity = quantity;
		this.totalcost = totalcost;
		this.orderdate = orderdate;
		this.status = status;
	}

	public OrderDetails(int orderid, int bookid, int cusid, int quantity, double totalcost, LocalDate orderdate,
			String status) {
		super();
		this.orderid = orderid;
		this.bookid = bookid;
		this.cusid = cusid;
		this.quantity = quantity;
		this.totalcost = totalcost;
		this.orderdate = orderdate;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Cart [bookid=" + bookid + ", cusid=" + cusid + ", quantity=" + quantity + ", totalcost=" + totalcost
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookid, cusid, quantity, totalcost);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDetails other = (OrderDetails) obj;
		return bookid == other.bookid && cusid == other.cusid && quantity == other.quantity
				&& Double.doubleToLongBits(totalcost) == Double.doubleToLongBits(other.totalcost);
	}

}
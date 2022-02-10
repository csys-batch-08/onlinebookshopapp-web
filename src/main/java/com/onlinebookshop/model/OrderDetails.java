package com.onlinebookshop.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class OrderDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int orderId;
	private int bookId;
	private int cusId;
	private int quantity;
	private double totalCost;
	private LocalDate orderDate;
	private String status;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookid(int bookId) {
		this.bookId = bookId;
	}

	public int getCusId() {
		return cusId;
	}

	public void setCusId(int cusId) {
		this.cusId = cusId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public OrderDetails() {
		super();

	}

	public OrderDetails(int bookId, int cusId, int quantity, double totalCost) {
		super();
		this.bookId = bookId;
		this.cusId = cusId;
		this.quantity = quantity;
		this.totalCost = totalCost;
	}

	public OrderDetails(int bookId, int cusId, int quantity, double totalCost, LocalDate orderDate, String status) {
		super();
		this.bookId = bookId;
		this.cusId = cusId;
		this.quantity = quantity;
		this.totalCost = totalCost;
		this.orderDate = orderDate;
		this.status = status;
	}

	public OrderDetails(int orderId, int bookId, int cusId, int quantity, double totalCost, LocalDate orderDate,
			String status) {
		super();
		this.orderId = orderId;
		this.bookId = bookId;
		this.cusId = cusId;
		this.quantity = quantity;
		this.totalCost = totalCost;
		this.orderDate = orderDate;
		this.status = status;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId + ", bookId=" + bookId + ", cusId=" + cusId + ", quantity=" + quantity
				+ ", totalCost=" + totalCost + ", orderDate=" + orderDate + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookId, cusId, orderDate, orderId, quantity, status, totalCost);
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
		return bookId == other.bookId && cusId == other.cusId && Objects.equals(orderDate, other.orderDate)
				&& orderId == other.orderId && quantity == other.quantity && Objects.equals(status, other.status)
				&& Double.doubleToLongBits(totalCost) == Double.doubleToLongBits(other.totalCost);
	}

	
}
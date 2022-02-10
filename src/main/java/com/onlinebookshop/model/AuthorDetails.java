package com.onlinebookshop.model;

import java.io.Serializable;
import java.util.Objects;

public class AuthorDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private String emailId;
	private int bookId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public AuthorDetails() {
		super();
	}

	public AuthorDetails(String name, String emailId, int bookId) {
		
		super();
		this.name = name;
		this.emailId = emailId;
		this.bookId = bookId;
	}

	@Override
	public String toString() {
		return "AuthorDetails [name=" + name + ", emailId=" + emailId + ", bookId=" + bookId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookId, emailId, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuthorDetails other = (AuthorDetails) obj;
		return Objects.equals(bookId, other.bookId) && Objects.equals(emailId, other.emailId)
				&& Objects.equals(name, other.name);
	}

}

package com.onlinebookshop.model;

import java.io.Serializable;
import java.util.Objects;

public class AuthorDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String emailid;
	private int bookid;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public AuthorDetails() {
		super();
	}
	public AuthorDetails(String name, String emailid, int bookid) {
		super();
		this.name = name;
		this.emailid = emailid;
		this.bookid = bookid;
	}
	@Override
	public String toString() {
		return "AuthorDetails [name=" + name + ", emailid=" + emailid + ", bookid=" + bookid + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(bookid, emailid, name);
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
		return Objects.equals(bookid, other.bookid) && Objects.equals(emailid, other.emailid)
				&& Objects.equals(name, other.name);
	}
	
}

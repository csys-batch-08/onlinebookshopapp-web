package com.onlinebookshop.model;

import java.io.Serializable;
import java.util.Objects;

public class Userdetails implements Serializable {

	private static final long serialVersionUID = 1L;

	private int cusId;
	private String name;
	private long phoneNo;
	private String address;
	private String emailId;
	private String password;
	private int wallet;
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getCusId() {
		return cusId;
	}

	public void setCusId(int cusId) {
		this.cusId = cusId;
	}

	public int getWallet() {
		return wallet;
	}

	public void setWallet(int wallet) {
		this.wallet = wallet;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailid() {
		return emailId;
	}

	public void setEmailid(String emailid) {
		this.emailId = emailid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Userdetails() {
		super();

	}

	public Userdetails(String name, long phoneNo, String address, String emailid, String password, int wallet) {

		this.name = name;
		this.phoneNo = phoneNo;
		this.address = address;
		this.emailId = emailid;
		this.password = password;
		this.wallet = wallet;
	}

	public Userdetails(int cusid) {

		this.cusId = cusid;

	}

	public Userdetails(int cusid, String name, long phoneNo, String role, String address, String emailid,
			String password, int wallet) {
		super();
		this.cusId = cusid;
		this.name = name;
		this.phoneNo = phoneNo;
		this.role = role;
		this.address = address;
		this.emailId = emailid;
		this.password = password;
		this.wallet = wallet;

	}

	@Override
	public String toString() {
		return "Userdetails [name=" + name + ", phoneNo=" + phoneNo + ", address=" + address + ", emailid=" + emailId
				+ ", password=" + password + ", cusid=" + cusId + ", wallet=" + wallet + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, cusId, emailId, name, password, phoneNo, wallet);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Userdetails other = (Userdetails) obj;
		return Objects.equals(address, other.address) && cusId == other.cusId && Objects.equals(emailId, other.emailId)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& phoneNo == other.phoneNo && wallet == other.wallet;
	}

}

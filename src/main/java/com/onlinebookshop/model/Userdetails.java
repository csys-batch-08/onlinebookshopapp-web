package com.onlinebookshop.model;

import java.util.Objects;

public class Userdetails {

	private int cus_id;
	private String name;
	private long phoneNo;
	private String address;
	private String email_id;
	private String password;
    private int wallet;
    private String role;
    
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getCus_id() {
	return cus_id;
}

public void setCus_id(int cus_id) {
	this.cus_id = cus_id;
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

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Userdetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Userdetails(String name, long phoneNo, String address, String email_id, String password,int wallet) {
		
		this.name = name;
		this.phoneNo = phoneNo;
		this.address = address;
		this.email_id = email_id;
		this.password = password;
		this.wallet = wallet;
	}
	public Userdetails(int cus_id) {
		
		this.cus_id = cus_id;
		
	}
	

	public Userdetails(int cus_id,String name, long phoneNo,String role,String address, String email_id, String password, 
			int wallet) {
		super();
		this.cus_id = cus_id;
		this.name = name;
		this.phoneNo = phoneNo;
		this.role = role;
		this.address = address;
		this.email_id = email_id;
		this.password = password;
		this.wallet = wallet;
		
	}

	@Override
	public String toString() {
		return "Userdetails [name=" + name + ", phoneNo=" + phoneNo + ", address=" + address + ", email_id=" + email_id
				+ ", password=" + password + ", cus_id=" + cus_id + ", wallet=" + wallet + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, cus_id, email_id, name, password, phoneNo, wallet);
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
		return Objects.equals(address, other.address) && cus_id == other.cus_id
				&& Objects.equals(email_id, other.email_id) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && phoneNo == other.phoneNo && wallet == other.wallet;
	}

	
}

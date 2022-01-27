package com.onlinebookshop.model;

import java.util.Objects;

public class Userdetails {

	private int cusid;
	private String name;
	private long phoneNo;
	private String address;
	private String emailid;
	private String password;
    private int wallet;
    private String role;
    
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getCusid() {
	return cusid;
}

public void setCusid(int cusid) {
	this.cusid = cusid;
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
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
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

	public Userdetails(String name, long phoneNo, String address, String email_id, String password,int wallet) {
		
		this.name = name;
		this.phoneNo = phoneNo;
		this.address = address;
		this.emailid = email_id;
		this.password = password;
		this.wallet = wallet;
	}
	public Userdetails(int cusid) {
		
		this.cusid = cusid;
		
	}
	

	public Userdetails(int cusid,String name, long phoneNo,String role,String address, String emailid, String password, 
			int wallet) {
		super();
		this.cusid = cusid;
		this.name = name;
		this.phoneNo = phoneNo;
		this.role = role;
		this.address = address;
		this.emailid = emailid;
		this.password = password;
		this.wallet = wallet;
		
	}

	@Override
	public String toString() {
		return "Userdetails [name=" + name + ", phoneNo=" + phoneNo + ", address=" + address + ", emailid=" + emailid
				+ ", password=" + password + ", cusid=" + cusid + ", wallet=" + wallet + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, cusid, emailid, name, password, phoneNo, wallet);
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
		return Objects.equals(address, other.address) && cusid == other.cusid
				&& Objects.equals(emailid, other.emailid) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && phoneNo == other.phoneNo && wallet == other.wallet;
	}

	
}

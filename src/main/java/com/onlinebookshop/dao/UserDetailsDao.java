package com.onlinebookshop.dao;

import java.util.List;

import com.onlinebookshop.model.Userdetails;

public interface UserDetailsDao {

	public void insertUser(Userdetails user);
	public Userdetails admin(String emailId,String password);
	public Userdetails validateUser(String emailId,String password);
	public void update(Userdetails user);
	public void deleteUser(String delete);
	public void activeUser(String delete);
	public List<Userdetails> viewUser();
	public List<Userdetails> viewParticularUser(String emailId);
	public int findUserId(String emailId);
	public int walletballance(int userId);
	public boolean updatewallet(Userdetails userDetails);
	public List<Userdetails> myProfile(int userId);
	public boolean refundAmount(Userdetails userDetails);
	public void forgotPassword(Userdetails user);
}

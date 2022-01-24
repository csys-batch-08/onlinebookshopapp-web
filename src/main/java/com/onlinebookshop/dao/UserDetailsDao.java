package com.onlinebookshop.dao;

import java.util.List;

import com.onlinebookshop.model.Userdetails;

public interface UserDetailsDao {

	public void insertUser(Userdetails user);
	public Userdetails admin(String email_id,String password);
	public Userdetails validateUser(String email_id,String password);
	public void update(Userdetails user);
	public void deleteuser(String delete);
	public List<Userdetails> viewUser();
	public int findUserId(String emailId);
	public int walletballance(int userid);
	public boolean  updatewall(Userdetails userdetails);
}

package com.onlinebookshop.dao;

import java.util.List;

import com.onlinebookshop.model.AuthorDetails;

public interface AuthorDetailsDao {

	public void insertAuthor(AuthorDetails author);
	public void updateAuthor(String email_id,String name);
	public List<AuthorDetails> showAuthor();
}

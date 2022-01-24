package com.onlinebookshop.dao;

import java.sql.SQLException;

import com.onlinebookshop.model.Rating;

public interface RatingDao {

	public int insertrating(Rating rating) throws SQLException;
	public double fetchrating(Rating rating);
}

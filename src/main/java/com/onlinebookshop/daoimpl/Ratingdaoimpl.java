package com.onlinebookshop.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.onlinebookshop.dao.RatingDao;
import com.onlinebookshop.model.Bookdetails;
import com.onlinebookshop.model.Rating;
import com.onlinebookshop.util.Connectionutil;

public class Ratingdaoimpl implements RatingDao{

	public int rating(Rating rating) throws SQLException {
		if(!ratingexist(rating.getCusid(), rating.getBookid())) {
			String  insert="insert into rating(cus_id,book_id,rating)values(?,?,?)";
			Connection con = null;
			PreparedStatement statement=null;
			try {
				con = Connectionutil.getDbConnection();
				statement =con.prepareStatement(insert);
				statement.setInt(1, rating.getCusid());
				statement.setInt(2, rating.getBookid());
				statement.setDouble(3, rating.getRating());
				int res =statement.executeUpdate();
				statement.executeUpdate("commit");
				
				return res;
				
			} catch (SQLException e) {

				e.printStackTrace();
				
			}finally {
				if (statement != null) {
					try {
						statement.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(con != null) {
					try {
						con.close();
					} catch (SQLException e) {
					
						e.printStackTrace();
					}
				}
			}
			
		return -1;
		}
		return -1;
	}
	public double fetchrating(Rating rating) {
		
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query ="select trunc(avg(rating),2) from rating where book_id =?";
		try {
			con = Connectionutil.getDbConnection();
			statement =con.prepareStatement(query);
			statement.setInt(1, rating.getBookid());
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				
				return resultSet.getDouble(1);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
			}
			if(resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
			}
		}
		return -1;
	}
	
	//rating exist:
	public boolean ratingexist(int userid ,int bookid) {
		Connection con = null;
		String query ="select id,cus_id,book_id,rating from rating where cus_id in ? and book_id in ?";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			con = Connectionutil.getDbConnection();
			statement = con.prepareStatement(query);
			statement.setInt(1, userid);
			statement.setInt(2, bookid);
			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
			}
			if(resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
			}
		}
		
		return false;
	}
}

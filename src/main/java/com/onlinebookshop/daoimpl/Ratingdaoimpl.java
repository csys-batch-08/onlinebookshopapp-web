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

	public int insertrating(Rating rating) throws SQLException {
		if(!ratingexist(rating.getCus_id(), rating.getBook_id())) {
			String  insert="insert into rating(cus_id,book_id,rating)values(?,?,?)";
			Connection con = Connectionutil.getDbConnection();
			PreparedStatement pstm=null;
			try {
				pstm =con.prepareStatement(insert);
				pstm.setInt(1, rating.getCus_id());
				pstm.setInt(2, rating.getBook_id());
				pstm.setDouble(3, rating.getRating());
				int res =pstm.executeUpdate();
				pstm.executeUpdate("commit");
				System.out.println("Ratings inserted ");
				return res;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Try again");
			}
			
		return -1;
		}
		return -1;
	}
	public double fetchrating(Rating rating) {
		Connection con = Connectionutil.getDbConnection();
		
		String query ="select trunc(avg(rating),2) from rating where book_id =?";
		try {
			PreparedStatement pst =con.prepareStatement(query);
			pst.setInt(1, rating.getBook_id());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				
				return rs.getDouble(1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	//rating exist:
	public boolean ratingexist(int userid ,int bookid) throws SQLException {
		Connection con = Connectionutil.getDbConnection();
		String query ="select * from rating where cus_id in ? and book_id in ?";
		PreparedStatement pst =con.prepareStatement(query);
		pst.setInt(1, userid);
		pst.setInt(2, bookid);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			return true;
		}
		return false;
	}
}

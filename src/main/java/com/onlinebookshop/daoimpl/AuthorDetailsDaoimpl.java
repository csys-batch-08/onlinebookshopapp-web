package com.onlinebookshop.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.onlinebookshop.dao.AuthorDetailsDao;
import com.onlinebookshop.model.AuthorDetails;
import com.onlinebookshop.model.Bookdetails;
import com.onlinebookshop.util.Connectionutil;

public class AuthorDetailsDaoimpl implements AuthorDetailsDao {

	public void insertAuthor(AuthorDetails author) {

		String insert = "insert into author_details(name,email_id,book_id)values(?,?,?)";
		Connection con = null;
		PreparedStatement statement = null;
		try {
			con = Connectionutil.getDbConnection();
			statement = con.prepareStatement(insert);
			statement.setString(1, author.getName());
			statement.setString(2, author.getEmailid());
			statement.setInt(3, author.getBookid());
			statement.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
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
	}

	public void updateAuthor(String emailid, String name) {
		String updateQuery = "update author_details set name=? where email_id=?";
		Connection con = null;
		PreparedStatement statement = null;
		try {
			con = Connectionutil.getDbConnection();
		    statement = con.prepareStatement(updateQuery);
			statement.setString(1, name);
			statement.setString(2, emailid);
			statement.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
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
	}

	public List<AuthorDetails> showAuthor() {
		List<AuthorDetails> authorList = new ArrayList<>();

		String show = "select name,email_id,book_id from author_details";
		Connection con = null;
	    Statement statement = null;
	    ResultSet resultset = null;
		try {
			con = Connectionutil.getDbConnection();
			statement = con.createStatement();
			resultset = statement.executeQuery(show);
			while (resultset.next()) {
				AuthorDetails author = new AuthorDetails(resultset.getString(1), resultset.getString(2), resultset.getInt(3));
				authorList.add(author);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
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
			if(resultset != null) {
				try {
					con.close();
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
			}
		}
		return authorList;
	}
}

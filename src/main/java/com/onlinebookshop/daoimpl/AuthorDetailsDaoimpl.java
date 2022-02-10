package com.onlinebookshop.daoimpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.onlinebookshop.dao.AuthorDetailsDao;
import com.onlinebookshop.logger.Logger;
import com.onlinebookshop.model.AuthorDetails;
import com.onlinebookshop.util.ConnectionUtil;
public class AuthorDetailsDaoimpl implements AuthorDetailsDao {

	/**
	 * This method is used to insert author details.
	 */
	public void insertAuthor(AuthorDetails author) {

		String insert = "insert into author_details(name,email_id,book_id)values(?,?,?)";
		Connection con = null;
		PreparedStatement statement = null;
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.prepareStatement(insert);
			statement.setString(1, author.getName());
			statement.setString(2, author.getEmailId());
			statement.setInt(3, author.getBookId());
			statement.executeUpdate();

		} catch (SQLException e) {

			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			try {
				ConnectionUtil.closeConnection(statement, con);
			} catch (SQLException e) {
				Logger.printStackTrace(e);
				Logger.runTimeException(e.getMessage());
			}
		}
	}

	/**
	 * This method is used to update author details.
	 */
	public void updateAuthor(String emailId, String name) {
		String updateQuery = "update author_details set name=? where email_id=?";
		Connection con = null;
		PreparedStatement statement = null;
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.prepareStatement(updateQuery);
			statement.setString(1, name);
			statement.setString(2, emailId);
			statement.executeUpdate();

		} catch (SQLException e) {

			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			try {
				ConnectionUtil.closeConnection(statement, con);
			} catch (SQLException e) {
				Logger.printStackTrace(e);
				Logger.runTimeException(e.getMessage());
			}
		}
	}

	/**
	 * This method is used to show all authors.
	 */
	public List<AuthorDetails> showAuthor() {
		List<AuthorDetails> authorList = new ArrayList<>();

		String show = "select name,email_id,book_id from author_details";
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.prepareStatement(show);
			resultset = statement.executeQuery();
			while (resultset.next()) {
				AuthorDetails author = new AuthorDetails(resultset.getString("name"), resultset.getString("email_id"),
						resultset.getInt("book_id"));
				authorList.add(author);
			}
		} catch (SQLException e) {

			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			try {
				ConnectionUtil.closeConnection(resultset, statement, con);
			} catch (SQLException e) {
				Logger.printStackTrace(e);
				Logger.runTimeException(e.getMessage());
			}
		}
		return authorList;
	}
}

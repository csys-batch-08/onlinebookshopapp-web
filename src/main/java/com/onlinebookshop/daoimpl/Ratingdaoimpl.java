package com.onlinebookshop.daoimpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.onlinebookshop.dao.RatingDao;
import com.onlinebookshop.logger.Logger;
import com.onlinebookshop.model.Rating;
import com.onlinebookshop.util.ConnectionUtil;

public class Ratingdaoimpl implements RatingDao {

	public int rating(Rating rating) throws SQLException {
		if (!ratingexist(rating.getCusId(), rating.getBookId())) {
			String insert = "insert into rating(cus_id,book_id,rating)values(?,?,?)";
			Connection con = null;
			PreparedStatement statement = null;
			try {
				con = ConnectionUtil.getDbConnection();
				statement = con.prepareStatement(insert);
				statement.setInt(1, rating.getCusId());
				statement.setInt(2, rating.getBookId());
				statement.setDouble(3, rating.getRating());
				int res = statement.executeUpdate();
				statement.executeUpdate("commit");

				return res;

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

			return -1;
		}
		return -1;
	}

	public double fetchrating(Rating rating) {

		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "select trunc(avg(rating),2) from rating where book_id =?";
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.prepareStatement(query);
			statement.setInt(1, rating.getBookId());
			resultSet = statement.executeQuery();
			while (resultSet.next()) {

				return resultSet.getDouble(1);

			}
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			try {
				ConnectionUtil.closeConnection(resultSet, statement, con);
			} catch (SQLException e) {
				Logger.printStackTrace(e);
				Logger.runTimeException(e.getMessage());
			}
		}
		return -1;
	}

	// rating exist:
	public boolean ratingexist(int userId, int bookId) {
		Connection con = null;
		String query = "select id,cus_id,book_id,rating from rating where cus_id in ? and book_id in ?";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.prepareStatement(query);
			statement.setInt(1, userId);
			statement.setInt(2, bookId);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				return true;
			}
		} catch (SQLException e) {

			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			try {
				ConnectionUtil.closeConnection(resultSet, statement, con);
			} catch (SQLException e) {
				Logger.printStackTrace(e);
				Logger.runTimeException(e.getMessage());
			}
		}

		return false;
	}
}

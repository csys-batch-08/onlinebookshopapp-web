package com.onlinebookshop.daoimpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.onlinebookshop.dao.CartDao;
import com.onlinebookshop.logger.Logger;
import com.onlinebookshop.model.*;
import com.onlinebookshop.util.ConnectionUtil;

public class CartDaoimpl implements CartDao {

	public int insertcart(Cart cart) throws SQLException {
		int res = 0;

		if (!cartexist(cart.getCusId(), cart.getBookId())) {

			String insertQuery = "insert into cart(book_id,cus_id)values(?,?)";
			Connection con = null;
			PreparedStatement statement = null;
			try {
				con = ConnectionUtil.getDbConnection();
				statement = con.prepareStatement(insertQuery);
				statement.setInt(1, cart.getBookId());
				statement.setInt(2, cart.getCartId());
				res = statement.executeUpdate();
				statement.executeUpdate("commit");

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
		return res;
	}

	// cart exist:
	public boolean cartexist(int userId, int bookId) {

		String query = "select cus_id,book_id from cart where cus_id in ? and book_id in ?";
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.prepareStatement(query);
			statement.setInt(1, userId);
			statement.setInt(2, bookId);
			resultset = statement.executeQuery();
			if (resultset.next()) {
				return true;
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

		return false;
	}

	public List<ProductDetails> fetchCart(int cusId) {

		List<ProductDetails> booklist = new ArrayList<>();
		String query = "select b.book_id,b.category,b.description,b.book_title,b.book_code,b.price,b.publish_date,b.condition,NVL(a.name,'NOT AVAILABLE')as AuthorName,NVL(a.email_id,'NOT AVAILABLE'),b.bookimages from bookdetails b inner join author_details a on b.book_id = a.book_id left join cart c on b.book_id = c.book_id where c.cus_id = ?";
		Connection con = null;
		ResultSet resultset = null;
		PreparedStatement statement = null;
		Ratingdaoimpl ratingdaoimpl = new Ratingdaoimpl();
		Rating rating = new Rating();

		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.prepareStatement(query);
			statement.setInt(1, cusId);
			resultset = statement.executeQuery();

			while (resultset.next()) {

				rating.setBookId(resultset.getInt(1));
				double rate = ratingdaoimpl.fetchrating(rating);
				ProductDetails product = new ProductDetails(resultset.getInt(1), resultset.getString(2),
						resultset.getString(3), resultset.getString(4), resultset.getString(5), resultset.getInt(6),
						resultset.getDate(7).toLocalDate(), resultset.getString(8), resultset.getString(9),
						resultset.getString(10), rate, resultset.getString(11));
				booklist.add(product);

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
		return booklist;
	}

	public List<Cart> allCart() {
		List<Cart> cartList = new ArrayList<>();
		String cart = "select cart_id,cus_id,book_id from cart";
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.prepareStatement(cart);
			resultset = statement.executeQuery();
			while (resultset.next()) {
				Cart cartmodel = new Cart(resultset.getInt("cart_id"), resultset.getInt("cus_id"),
						resultset.getInt("book_id"));
				cartList.add(cartmodel);
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
		return cartList;

	}

	public int deleteCart(int bookId, int userId) {

		String delete = "delete from cart where book_id=? and cus_id=?";
		Connection con = null;
		PreparedStatement statement = null;
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.prepareStatement(delete);
			statement.setInt(1, bookId);
			statement.setInt(2, userId);
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
		return 0;
	}
}

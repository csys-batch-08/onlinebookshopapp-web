package com.onlinebookshop.daoimpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.onlinebookshop.dao.BookdetailsDao;
import com.onlinebookshop.logger.Logger;
import com.onlinebookshop.model.Bookdetails;
import com.onlinebookshop.model.ProductDetails;
import com.onlinebookshop.model.Rating;

import com.onlinebookshop.util.ConnectionUtil;

public class BookdetailsDaoimpl implements BookdetailsDao {

	public int insertBooks(Bookdetails product) {
		String insert = "insert into bookdetails(category,description,book_title,book_code,price,publish_date,condition,bookimages)values(?,?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement statement = null;
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.prepareStatement(insert);
			statement.setString(1, product.getCategory());
			statement.setString(2, product.getDescription());
			statement.setString(3, product.getBookTitle());
			statement.setString(4, product.getBookCode());
			statement.setInt(5, product.getPrice());
			statement.setDate(6, java.sql.Date.valueOf(product.getPublishDate()));
			statement.setString(7, product.getCondition());
			statement.setString(8, product.getBookImages());
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
		return 1;
	}

	public void deleteBooks(int product) {
		String delete = "update bookdetails set status='Not Available' where book_id=?";
		Connection con = null;
		PreparedStatement statement = null;
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.prepareStatement(delete);
			statement.setInt(1, product);
			statement.executeUpdate();
			statement.execute("commit");
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

	public List<ProductDetails> showProduct() {
		List<ProductDetails> productsList = new ArrayList<>();

		String show = "select b.book_id,b.category,b.description,b.book_title,b.book_code,b.price,b.publish_date,b.condition,NVL(a.name,'NOT AVAILABLE')as AuthorName,NVL(a.email_id,'NOT AVAILABLE'),b.bookimages from bookdetails b left join author_details a on b.book_id = a.book_id where status='Available'";

		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Rating rating = new Rating();
		Ratingdaoimpl ratingdaoimpl = new Ratingdaoimpl();

		try {

			con = ConnectionUtil.getDbConnection();
			statement = con.prepareStatement(show);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				rating.setBookId(resultSet.getInt(1));
				double rate = ratingdaoimpl.fetchrating(rating);
				ProductDetails product = new ProductDetails(resultSet.getInt(1), resultSet.getString(2),
						resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getInt(6),
						resultSet.getDate(7).toLocalDate(), resultSet.getString(8), resultSet.getString(9),
						resultSet.getString(10), rate, resultSet.getString(11));
				productsList.add(product);

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

		return productsList;
	}

	public List<ProductDetails> showBook(int bookId) {
		List<ProductDetails> productsList = new ArrayList<>();

		String show = "select b.book_id,b.category,b.description,b.book_title,b.book_code,b.price,b.publish_date,b.condition,NVL(a.name,'NOT AVAILABLE')as AuthorName,NVL(a.email_id,'NOT AVAILABLE'),b.bookimages from bookdetails b left join author_details a on b.book_id = a.book_id where b.book_id=?";
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;

		Rating rating = new Rating();
		Ratingdaoimpl ratingdaoimpl = new Ratingdaoimpl();
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.prepareStatement(show);

			statement.setInt(1, bookId);
			resultset = statement.executeQuery();

			while (resultset.next()) {
				rating.setBookId(resultset.getInt(1));
				double rate = ratingdaoimpl.fetchrating(rating);

				ProductDetails product = new ProductDetails(resultset.getInt(1), resultset.getString(2),
						resultset.getString(3), resultset.getString(4), resultset.getString(5), resultset.getInt(6),
						resultset.getDate(7).toLocalDate(), resultset.getString(8), resultset.getString(9),
						resultset.getString(10), rate, resultset.getString(11));
				productsList.add(product);

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

		return productsList;
	}

	public int findProductid(String bookTitle) {
		String find = "select book_id from bookdetails where book_title= ?";
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int productId = 0;
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.prepareStatement(find);
			statement.setString(1, bookTitle);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				productId = resultSet.getInt(1);
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
		return productId;

	}

	public String findBookname(int bookId) {
		String find = "select book_title from bookdetails where book_id = ?";
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		String product = null;
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.prepareStatement(find);
			statement.setInt(1, bookId);
			resultset = statement.executeQuery();
			if (resultset.next()) {
				product = resultset.getString(1);
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
		return product;

	}

	public int findPrice(int productId) {
		String query = "select price from bookdetails where book_id = ? ";
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		int price = 0;
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.prepareStatement(query);
			statement.setInt(1, productId);
			resultset = statement.executeQuery();
			if (resultset.next()) {
				price = resultset.getInt(1);
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
		return price;
	}

	public void updateBooks(Bookdetails bookDetails) {
		String updateQuery = "update bookdetails set price=? where book_title=?";
		Connection con = null;
		PreparedStatement statement = null;
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.prepareStatement(updateQuery);
			statement.setInt(1, bookDetails.getPrice());
			statement.setString(2, bookDetails.getBookTitle());
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

	public List<ProductDetails> filterPrice(int price) {

		List<ProductDetails> filterPrice = new ArrayList<>();
		String filter = "select b.book_id,b.category,b.description,b.book_title,b.book_code,b.price,b.publish_date,b.condition,NVL(a.name,'NOT AVAILABLE')as AuthorName,NVL(a.email_id,'NOT AVAILABLE'),b.bookimages from bookdetails b left join author_details a on b.book_id = a.book_id where price <= ?";
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		Rating rating = new Rating();
		Ratingdaoimpl ratingdaoimpl = new Ratingdaoimpl();
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.prepareStatement(filter);
			statement.setInt(1, price);
			resultset = statement.executeQuery();
			while (resultset.next()) {
				rating.setBookId(resultset.getInt(1));
				double rate = ratingdaoimpl.fetchrating(rating);
				ProductDetails product = new ProductDetails(resultset.getInt(1), resultset.getString(2),
						resultset.getString(3), resultset.getString(4), resultset.getString(5), resultset.getInt(6),
						resultset.getDate(7).toLocalDate(), resultset.getString(8), resultset.getString(9),
						resultset.getString(10), rate, resultset.getString(11));
				filterPrice.add(product);
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
		return filterPrice;
	}

	public List<ProductDetails> filterName(String bookTitle) {

		List<ProductDetails> filterName = new ArrayList<>();
		String bookName = "%" + bookTitle + "%";

		String filter = "select b.book_id,b.category,b.description,b.book_title,b.book_code,b.price,b.publish_date,b.condition,NVL(a.name,'NOT AVAILABLE')as AuthorName,NVL(a.email_id,'NOT AVAILABLE'),b.bookimages from bookdetails b left join author_details a on b.book_id = a.book_id where b.book_title like ?";
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		Rating rating = new Rating();
		Ratingdaoimpl ratingdaoimpl = new Ratingdaoimpl();
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.prepareStatement(filter);
			statement.setString(1, bookName);
			resultset = statement.executeQuery();

			while (resultset.next()) {
				rating.setBookId(resultset.getInt(1));
				double rate = ratingdaoimpl.fetchrating(rating);
				ProductDetails product = new ProductDetails(resultset.getInt(1), resultset.getString(2),
						resultset.getString(3), resultset.getString(4), resultset.getString(5), resultset.getInt(6),
						resultset.getDate(7).toLocalDate(), resultset.getString(8), resultset.getString(9),
						resultset.getString(10), rate, resultset.getString(11));
				filterName.add(product);

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
		return filterName;
	}

	public List<ProductDetails> filterCondition() {
		List<ProductDetails> conditionList = new ArrayList<>();
		String condition = "select b.book_id,b.category,b.description,b.book_title,b.book_code,b.price,b.publish_date,b.condition,NVL(a.name,'NOT AVAILABLE')as AuthorName,NVL(a.email_id,'NOT AVAILABLE'),b.bookimages from bookdetails b left join author_details a on b.book_id = a.book_id where b.condition='old'";
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		Rating rating = new Rating();
		Ratingdaoimpl ratingdaoimpl = new Ratingdaoimpl();
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.prepareStatement(condition);
			resultset = statement.executeQuery();
			while (resultset.next()) {
				rating.setBookId(resultset.getInt(1));
				double rate = ratingdaoimpl.fetchrating(rating);
				ProductDetails product = new ProductDetails(resultset.getInt(1), resultset.getString(2),
						resultset.getString(3), resultset.getString(4), resultset.getString(5), resultset.getInt(6),
						resultset.getDate(7).toLocalDate(), resultset.getString(8), resultset.getString(9),
						resultset.getString(10), rate, resultset.getString(11));
				conditionList.add(product);
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
		return conditionList;
	}

	public List<Bookdetails> categoryList() {
		List<Bookdetails> categoryList = new ArrayList<>();
		String category = "select category from bookdetails";
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.prepareStatement(category);
			resultset = statement.executeQuery();
			while (resultset.next()) {
				Bookdetails categorylist = new Bookdetails(resultset.getString(2), resultset.getString(3),
						resultset.getString(4), resultset.getString(5), resultset.getInt(6),
						resultset.getDate(7).toLocalDate(), resultset.getString(8), resultset.getString(9));
				categoryList.add(categorylist);
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
		return categoryList;
	}

	public List<Bookdetails> viewAllBook() {
		List<Bookdetails> productsList = new ArrayList<>();

		String show = "select book_id,category,description,book_title,book_code,price,publish_date,condition,bookimages,status from bookdetails";
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.prepareStatement(show);
			resultset = statement.executeQuery();
			while (resultset.next()) {
				Bookdetails book = new Bookdetails(resultset.getInt(1), resultset.getString(2), resultset.getString(3),
						resultset.getString(4), resultset.getString(5), resultset.getInt(6),
						resultset.getDate(7).toLocalDate(), resultset.getString(8), resultset.getString(9),
						resultset.getString(10));
				productsList.add(book);

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

		return productsList;
	}

	public List<ProductDetails> ratingproducts(int bookId) {

		Rating rating = new Rating();
		Ratingdaoimpl ratingdaoimpl = new Ratingdaoimpl();
		List<ProductDetails> bookdetails = new ArrayList<>();

		String query = "select b.book_id,b.category,b.description,b.book_title,b.book_code,b.price,b.publish_date,b.condition,NVL(a.name,'NOT AVAILABLE')as AuthorName,NVL(a.email_id,'NOT AVAILABLE'),b.bookimages from bookdetails b left join author_details a on b.book_id = a.book_id where b.book_id in ?";

		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;

		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.prepareStatement(query);
			statement.setInt(1, bookId);
			resultset = statement.executeQuery();
			while (resultset.next()) {
				rating.setBookId(resultset.getInt(1));
				double rate = ratingdaoimpl.fetchrating(rating);
				bookdetails.add(new ProductDetails(resultset.getInt(1), resultset.getString(2), resultset.getString(3),
						resultset.getString(4), resultset.getString(5), resultset.getInt(6),
						resultset.getDate(7).toLocalDate(), resultset.getString(8), resultset.getString(9),
						resultset.getString(10), rate, resultset.getString(11)));
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
		return bookdetails;
	}

}

package com.onlinebookshop.daoimpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.onlinebookshop.dao.OrderDetailsDao;
import com.onlinebookshop.logger.Logger;
import com.onlinebookshop.model.OrderDetails;
import com.onlinebookshop.util.Connectionutil;

public class OrderDetailsDaoimpl implements OrderDetailsDao {

	private static final String STATUS = "status";
	private static final String BOOK_ID = "book_id";
	private static final String TOTAL_COST = "total_cost";
	private static final String CUS_ID = "cus_id";
	private static final String QUANTITY = "quantity";
	private static final String ORDER_DATE = "order_date";

	public void insertOrder(OrderDetails cart) {
		String query = "insert into orderdetails(cus_id,book_id,quantity,total_cost) values(?,?,?,?)";
		Connection con = null;
		PreparedStatement statement = null;
		try {
			con = Connectionutil.getDbConnection();
			statement = con.prepareStatement(query);
			statement.setInt(1, cart.getCusid());
			statement.setInt(2, cart.getBookid());
			statement.setInt(3, cart.getQuantity());
			statement.setDouble(4, cart.getTotalcost());
			statement.executeUpdate();

		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			try {
				Connectionutil.closeConnection(statement, con);
			} catch (SQLException e) {
				Logger.printStackTrace(e);
				Logger.runTimeException(e.getMessage());
			}
		}
	}

	public List<OrderDetails> viewOrder() {
		List<OrderDetails> orderList = new ArrayList<>();

		String query = "select cus_id,book_id,quantity,total_cost,order_date,status from orderdetails order by order_id desc";
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			con = Connectionutil.getDbConnection();
			statement = con.prepareStatement(query);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				OrderDetails order = new OrderDetails(resultSet.getInt(CUS_ID), resultSet.getInt(BOOK_ID),
						resultSet.getInt(QUANTITY), resultSet.getDouble(TOTAL_COST),
						resultSet.getDate(ORDER_DATE).toLocalDate(), resultSet.getString(STATUS));
				orderList.add(order);
			}
		} catch (SQLException e) {

			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			try {
				Connectionutil.closeConnection(resultSet, statement, con);
			} catch (SQLException e) {
				Logger.printStackTrace(e);
				Logger.runTimeException(e.getMessage());
			}
		}
		return orderList;
	}

	public List<OrderDetails> filterOrderDate(String orderdate) {
		List<OrderDetails> orderList = new ArrayList<>();

		String view = "select cus_id,book_id,quantity,total_cost,order_date,status from orderdetails where to_char(trunc(order_date),'yyyy-MM-dd') = ?";
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			con = Connectionutil.getDbConnection();
			statement = con.prepareStatement(view);
			statement.setString(1, orderdate);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				OrderDetails order = new OrderDetails(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3),
						resultSet.getDouble(4), resultSet.getDate(5).toLocalDate(), resultSet.getString(6));
				orderList.add(order);
			}
		} catch (SQLException e) {

			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			try {
				Connectionutil.closeConnection(resultSet, statement, con);
			} catch (SQLException e) {
				Logger.printStackTrace(e);
				Logger.runTimeException(e.getMessage());
			}
		}
		return orderList;
	}

	public List<OrderDetails> cancelledOrder() {
		List<OrderDetails> orderList = new ArrayList<>();

		String cancelorder = "select cus_id,book_id,quantity,total_cost,order_date,status from orderdetails where status = 'order canceled'";
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			con = Connectionutil.getDbConnection();
			statement = con.prepareStatement(cancelorder);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				OrderDetails order = new OrderDetails(resultSet.getInt(CUS_ID), resultSet.getInt(BOOK_ID),
						resultSet.getInt(QUANTITY), resultSet.getDouble(TOTAL_COST),
						resultSet.getDate(ORDER_DATE).toLocalDate(), resultSet.getString(STATUS));
				orderList.add(order);
			}
		} catch (SQLException e) {

			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			try {
				Connectionutil.closeConnection(resultSet, statement, con);
			} catch (SQLException e) {
				Logger.printStackTrace(e);
				Logger.runTimeException(e.getMessage());
			}
		}
		return orderList;
	}

	public int updateOrder(int quantity, int bookid) {
		String updateQuery = "update orderdetails set quantity=? where book_id=?";
		Connection con = null;
		PreparedStatement statement = null;
		try {
			con = Connectionutil.getDbConnection();
			statement = con.prepareStatement(updateQuery);
			statement.setInt(2, bookid);
			statement.setInt(1, quantity);
			statement.executeUpdate();

		} catch (SQLException e) {

			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());

		} finally {
			try {
				Connectionutil.closeConnection(statement, con);
			} catch (SQLException e) {
				Logger.printStackTrace(e);
				Logger.runTimeException(e.getMessage());
			}
		}
		return 0;

	}

	public int cancelOrder(int orderid) {

		String deleteOrder = "update orderdetails set status='order canceled'  where order_id=?";
		Connection con = null;
		PreparedStatement statement = null;
		try {
			con = Connectionutil.getDbConnection();
			statement = con.prepareStatement(deleteOrder);
			statement.setInt(1, orderid);
			statement.executeUpdate();
			statement.executeUpdate("commit");

		} catch (SQLException e) {

			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			try {
				Connectionutil.closeConnection(statement, con);
			} catch (SQLException e) {
				Logger.printStackTrace(e);
				Logger.runTimeException(e.getMessage());
			}
		}
		return 1;
	}

	public boolean orderCancelled(int orderid) {
		Connection con = null;
		String query = "select order_id,cus_id,book_id,quantity,total_cost,order_date,status from rating where status='order canceled' and order_id in ?";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			con = Connectionutil.getDbConnection();
			statement = con.prepareStatement(query);
			statement.setInt(1, orderid);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				return true;
			}
		} catch (SQLException e) {

			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			try {
				Connectionutil.closeConnection(resultSet, statement, con);
			} catch (SQLException e) {
				Logger.printStackTrace(e);
				Logger.runTimeException(e.getMessage());
			}
		}

		return false;
	}

	public List<OrderDetails> viewUserOrder(int userid) {

		List<OrderDetails> orderList = new ArrayList<>();
		String myCart = "select order_id,cus_id,book_id,quantity,total_cost,order_date,status from orderdetails where cus_id=? order by order_id desc";

		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			con = Connectionutil.getDbConnection();
			statement = con.prepareStatement(myCart);
			statement.setInt(1, userid);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {

				OrderDetails order = new OrderDetails(resultSet.getInt("order_id"), resultSet.getInt(CUS_ID),
						resultSet.getInt(BOOK_ID), resultSet.getInt(QUANTITY), resultSet.getDouble(TOTAL_COST),
						resultSet.getDate(ORDER_DATE).toLocalDate(), resultSet.getString(STATUS));
				orderList.add(order);

			}

		} catch (SQLException e) {

			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());

		} finally {
			try {
				Connectionutil.closeConnection(resultSet, statement, con);
			} catch (SQLException e) {
				Logger.printStackTrace(e);
				Logger.runTimeException(e.getMessage());
			}
		}
		return orderList;
	}

	public int findOrderPrice(int orderid) {
		String find = "select total_cost from orderdetails where order_id = ? ";
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int productId = 0;
		try {
			con = Connectionutil.getDbConnection();
			statement = con.prepareStatement(find);
			statement.setInt(1, orderid);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				productId = resultSet.getInt(1);
			}
		} catch (SQLException e) {

			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			try {
				Connectionutil.closeConnection(resultSet, statement, con);
			} catch (SQLException e) {
				Logger.printStackTrace(e);
				Logger.runTimeException(e.getMessage());
			}
		}
		return productId;

	}

	public String findStatus(int orderid) {
		String find = "select status from orderdetails where order_id= ?";
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String status = null;
		try {
			con = Connectionutil.getDbConnection();
			statement = con.prepareStatement(find);
			statement.setInt(1, orderid);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				status = resultSet.getString(1);
			}
		} catch (SQLException e) {

			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			try {
				Connectionutil.closeConnection(resultSet, statement, con);
			} catch (SQLException e) {
				Logger.printStackTrace(e);
				Logger.runTimeException(e.getMessage());
			}
		}
		return status;

	}

}
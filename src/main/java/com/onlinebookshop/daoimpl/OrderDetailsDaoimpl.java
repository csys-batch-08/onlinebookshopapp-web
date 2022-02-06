package com.onlinebookshop.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.onlinebookshop.dao.OrderDetailsDao;

import com.onlinebookshop.model.OrderDetails;

import com.onlinebookshop.util.Connectionutil;

public class OrderDetailsDaoimpl implements OrderDetailsDao {

	public void insertOrder(OrderDetails cart) {
		String insertQuery = "insert into orderdetails(cus_id,book_id,quantity,total_cost) values(?,?,?,?)";
		Connection con = null;
		PreparedStatement statement = null;
		try {
			con = Connectionutil.getDbConnection();
			statement = con.prepareStatement(insertQuery);
			statement.setInt(1, cart.getCusid());
			statement.setInt(2, cart.getBookid());
			statement.setInt(3, cart.getQuantity());
			statement.setDouble(4, cart.getTotalcost());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.getMessage();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.getMessage();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {

					e.getMessage();
				}
			}
		}
	}

	public List<OrderDetails> viewOrder() {
		List<OrderDetails> orderList = new ArrayList<>();

		String view = "select cus_id,book_id,quantity,total_cost,order_date,status from orderdetails order by order_id desc";
		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			con = Connectionutil.getDbConnection();
			statement = con.createStatement();
			resultSet = statement.executeQuery(view);
			while (resultSet.next()) {
				OrderDetails order = new OrderDetails(resultSet.getInt("cus_id"), resultSet.getInt("book_id"),
						resultSet.getInt("quantity"), resultSet.getDouble("total_cost"),
						resultSet.getDate("order_date").toLocalDate(), resultSet.getString("status"));
				orderList.add(order);
			}
		} catch (SQLException e) {

			e.getMessage();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.getMessage();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {

					e.getMessage();
				}
			}
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {

					e.getMessage();
				}
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

			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.getMessage();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {

					e.getMessage();
				}
			}
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {

					e.getMessage();
				}
			}
		}
		return orderList;
	}

	public List<OrderDetails> cancelledOrder() {
		List<OrderDetails> orderList = new ArrayList<>();

		String cancelorder = "select cus_id,book_id,quantity,total_cost,order_date,status from orderdetails where status = 'order canceled'";
		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			con = Connectionutil.getDbConnection();
			statement = con.createStatement();

			resultSet = statement.executeQuery(cancelorder);
			while (resultSet.next()) {
				OrderDetails order = new OrderDetails(resultSet.getInt("cus_id"), resultSet.getInt("book_id"),
						resultSet.getInt("quantity"), resultSet.getDouble("total_cost"),
						resultSet.getDate("order_date").toLocalDate(), resultSet.getString("status"));
				orderList.add(order);
			}
		} catch (SQLException e) {

			e.getMessage();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.getMessage();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {

					e.getMessage();
				}
			}
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {

					e.getMessage();
				}
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

			e.getMessage();

		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.getMessage();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {

					e.getMessage();
				}
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

			e.getMessage();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.getMessage();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {

					e.getMessage();
				}
			}
		}
		return 1;
	}

	// rating exist:
	public boolean orderCancelled(String status, int orderid) {
		Connection con = null;
		String query = "select order_id,cus_id,book_id,quantity,total_cost,order_date,status from rating where status='order canceled' and order_id in ?";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			con = Connectionutil.getDbConnection();
			statement = con.prepareStatement(query);
			statement.setString(1, status);
			statement.setInt(2, orderid);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				return true;
			}
		} catch (SQLException e) {

			e.getMessage();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.getMessage();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {

					e.getMessage();
				}
			}
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {

					e.getMessage();
				}
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

				OrderDetails order = new OrderDetails(resultSet.getInt("order_id"), resultSet.getInt("cus_id"),
						resultSet.getInt("book_id"), resultSet.getInt("quantity"), resultSet.getDouble("total_cost"),
						resultSet.getDate("order_date").toLocalDate(), resultSet.getString("status"));
				orderList.add(order);

			}

		} catch (SQLException e) {

			e.getMessage();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.getMessage();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {

					e.getMessage();
				}
			}
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {

					e.getMessage();
				}
			}
		}
		return orderList;
	}

	public int findOrderPrice(int orderid) {
		String find = "select total_cost from orderdetails where order_id='" + orderid + "'";
		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;
		int productId = 0;
		try {
			con = Connectionutil.getDbConnection();
			statement = con.createStatement();
			resultSet = statement.executeQuery(find);
			if (resultSet.next()) {
				productId = resultSet.getInt(1);
			}
		} catch (SQLException e) {

			e.getMessage();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.getMessage();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {

					e.getMessage();
				}
			}
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {

					e.getMessage();
				}
			}
		}
		return productId;

	}

	public String findStatus(int orderid) {
		String find = "select status from orderdetails where order_id='" + orderid + "'";
		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String status = null;
		try {
			con = Connectionutil.getDbConnection();
			statement = con.createStatement();
			resultSet = statement.executeQuery(find);
			if (resultSet.next()) {
				status = resultSet.getString(1);
			}
		} catch (SQLException e) {

			e.getMessage();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.getMessage();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {

					e.getMessage();
				}
			}
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {

					e.getMessage();
				}
			}
		}
		return status;

	}

}
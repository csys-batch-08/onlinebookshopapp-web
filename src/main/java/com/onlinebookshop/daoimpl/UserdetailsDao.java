package com.onlinebookshop.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.onlinebookshop.dao.UserDetailsDao;
import com.onlinebookshop.logger.Logger;
import com.onlinebookshop.model.Userdetails;
import com.onlinebookshop.util.Connectionutil;

public class UserdetailsDao implements UserDetailsDao {

	private static final String EMAIL_ID = "email_id";
	private static final String PASSWORD = "password";
	private static final String ADDRESS = "address";
	private static final String WALLET = "wallet";
	private static final String NAME = "name";
	private static final String CUS_ID = "cus_id";
	private static final String PHONE_NO = "phoneNo";

	public void insertUser(Userdetails user) {
		String insertQuery = "insert into user_details(name,phoneNo,address,email_id,password) values(?,?,?,?,?)";

		Connection con = null;
		PreparedStatement statement = null;

		try {
			con = Connectionutil.getDbConnection();
			statement = con.prepareStatement(insertQuery);
			statement.setString(1, user.getName());
			statement.setLong(2, user.getPhoneNo());
			statement.setString(3, user.getAddress());
			statement.setString(4, user.getEmailid());
			statement.setString(5, user.getPassword());

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

	public Userdetails admin(String emailid, String password) {
		String adminQuery = "select cus_id,name,phoneNo,role,address,email_id,password,wallet from user_details where role='admin'and email_id = ? and password = ?";

		Userdetails user = null;

		Connection con = null;
		ResultSet resultset = null;
		PreparedStatement statement = null;
		try {
			con = Connectionutil.getDbConnection();
			statement = con.prepareStatement(adminQuery);
			statement.setString(1, emailid);
			statement.setString(2, password);
			resultset = statement.executeQuery();
			if (resultset.next()) {
				user = new Userdetails(resultset.getInt(CUS_ID), resultset.getString(NAME), resultset.getLong(PHONE_NO),
						resultset.getString("role"), resultset.getString(ADDRESS), emailid, password,
						resultset.getInt(WALLET));
			}
		} catch (SQLException e) {

			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			try {
				Connectionutil.closeConnection(resultset,statement, con);
			} catch (SQLException e) {
				Logger.printStackTrace(e);
				Logger.runTimeException(e.getMessage());
			}
		}
		return user;
	}

	// user
	public Userdetails validateUser(String emailid, String password) {
		String validateQuery = "select cus_id,name,phoneNo,role,address,email_id,password,wallet from user_details where role='user'  and  email_id = ? and password = ? ";

		Userdetails user = null;

		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			con = Connectionutil.getDbConnection();
			statement = con.prepareStatement(validateQuery);
			statement.setString(1, emailid);
			statement.setString(2, password);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				user = new Userdetails(resultSet.getInt(CUS_ID), resultSet.getString(NAME), resultSet.getLong(PHONE_NO),
						resultSet.getString("role"), resultSet.getString(ADDRESS), emailid, password,
						resultSet.getInt(WALLET));
			}

		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			try {
				Connectionutil.closeConnection(resultSet,statement, con);
			} catch (SQLException e) {
				Logger.printStackTrace(e);
				Logger.runTimeException(e.getMessage());
			}
		}
		return user;
	}

	// update profile
	public void update(Userdetails user) {
		String updateQuery = "update user_details set name=?,phoneNo=?,address=?,password=? where email_id=?";
		Connection con = null;
		PreparedStatement statement = null;
		try {
			con = Connectionutil.getDbConnection();
			statement = con.prepareStatement(updateQuery);
			statement.setString(1, user.getName());
			statement.setLong(2, user.getPhoneNo());
			statement.setString(3, user.getAddress());
			statement.setString(4, user.getPassword());
			statement.setString(5, user.getEmailid());
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
	// Delete user details

	public void deleteuser(String delete) {
		String deleteQuery = "update user_details set role='Inactive' where email_id=?";
		Connection con = null;
		PreparedStatement statement = null;
		try {
			con = Connectionutil.getDbConnection();
			statement = con.prepareStatement(deleteQuery);
			statement.setString(1, delete);
			statement.executeUpdate();
			statement.execute("commit");

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

	public void activeUser(String delete) {
		String deleteQuery = "update user_details set role='user' where email_id=?";
		Connection con = null;
		PreparedStatement statement = null;
		try {
			con = Connectionutil.getDbConnection();
			statement = con.prepareStatement(deleteQuery);
			statement.setString(1, delete);
			statement.executeUpdate();
			statement.execute("commit");
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

	public List<Userdetails> viewUser() {
		List<Userdetails> userList = new ArrayList<>();
		String show = "select cus_id,name,phoneNo,role,address,email_id,password,wallet from user_details where role!='admin'";
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			con = Connectionutil.getDbConnection();
			statement = con.prepareStatement(show);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Userdetails user = new Userdetails(resultSet.getInt(CUS_ID), resultSet.getString(NAME),
						resultSet.getLong(PHONE_NO), resultSet.getString("role"), resultSet.getString(ADDRESS),
						resultSet.getString(EMAIL_ID), resultSet.getString(PASSWORD), resultSet.getInt(WALLET));
				userList.add(user);
			}
		} catch (SQLException e) {

			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			try {
				Connectionutil.closeConnection(resultSet,statement, con);
			} catch (SQLException e) {
				Logger.printStackTrace(e);
				Logger.runTimeException(e.getMessage());
			}
		}
		return userList;
	}

	public List<Userdetails> viewParticularUser(String emailid) {
		List<Userdetails> userList = new ArrayList<>();
		String show = "select cus_id,name,phoneNo,role,address,email_id,password,wallet from user_details where email_id = ?";
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			con = Connectionutil.getDbConnection();
			statement = con.prepareStatement(show);
			statement.setString(1, emailid);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Userdetails user = new Userdetails(resultSet.getInt(CUS_ID), resultSet.getString(NAME),
						resultSet.getLong(PHONE_NO), resultSet.getString("role"), resultSet.getString(ADDRESS),
						resultSet.getString(EMAIL_ID), resultSet.getString(PASSWORD), resultSet.getInt(WALLET));
				userList.add(user);

			}
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			try {
				Connectionutil.closeConnection(resultSet,statement, con);
			} catch (SQLException e) {
				Logger.printStackTrace(e);
				Logger.runTimeException(e.getMessage());
			}
		}
		return userList;
	}

	public int findUserId(String emailId) {
		String findUser = "select cus_id from user_details where email_id = ?";
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int cusId = 0;
		try {
			con = Connectionutil.getDbConnection();
			statement = con.prepareStatement(findUser);
			statement.setString(1, emailId);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				cusId = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			try {
				Connectionutil.closeConnection(resultSet,statement, con);
			} catch (SQLException e) {
				Logger.printStackTrace(e);
				Logger.runTimeException(e.getMessage());
			}
		}
		return cusId;
	}

	public int walletballance(int userid) {

		String query = "select wallet from user_details where cus_id = ?";
		PreparedStatement statement = null;
		Connection con = null;
		ResultSet resultSet = null;
		try {
			con = Connectionutil.getDbConnection();
			statement = con.prepareStatement(query);
			statement.setInt(1, userid);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				return resultSet.getInt(1);
			}
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			try {
				Connectionutil.closeConnection(resultSet,statement, con);
			} catch (SQLException e) {
				Logger.printStackTrace(e);
				Logger.runTimeException(e.getMessage());
			}
		}
		return -1;
	}

	// update wallet:
	public boolean updatewallet(Userdetails userdetails) {

		String query = "update user_details set wallet = ? where email_id = ?";

		Connection con = null;
		PreparedStatement statement = null;
		
		try {
			con = Connectionutil.getDbConnection();
			statement = con.prepareStatement(query);
			statement.setInt(1, userdetails.getWallet());
			statement.setString(2, userdetails.getEmailid());
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
		return true;
	}

	public List<Userdetails> myProfile(int userid) {
		List<Userdetails> userList = new ArrayList<>();
		String profile = "select name,phoneno,address,email_id,password,wallet from user_details where cus_id=?";
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			con = Connectionutil.getDbConnection();
			statement = con.prepareStatement(profile);
			statement.setInt(1, userid);

			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Userdetails user = new Userdetails(resultSet.getString(NAME), resultSet.getLong("phoneno"),
						resultSet.getString(ADDRESS), resultSet.getString(EMAIL_ID), resultSet.getString(PASSWORD),
						resultSet.getInt(WALLET));
				userList.add(user);
			}
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			try {
				Connectionutil.closeConnection(resultSet,statement, con);
			} catch (SQLException e) {
				Logger.printStackTrace(e);
				Logger.runTimeException(e.getMessage());
			}
		}
		return userList;
	}

	public boolean refundWallet(Userdetails userdetails) {

		String query = "update user_details set wallet = ? where email_id = ?";

		Connection con = null;
		PreparedStatement statement = null;
		try {

			con = Connectionutil.getDbConnection();
			statement = con.prepareStatement(query);
			statement.setInt(1, userdetails.getWallet());
			statement.setString(2, userdetails.getEmailid());
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
		return true;
	}

	public void forgotPassword(Userdetails user) {
		String updateQuery = "update user_details set password=? where email_id=?";
		Connection con = null;
		PreparedStatement statement = null;
		try {
			con = Connectionutil.getDbConnection();
			statement = con.prepareStatement(updateQuery);
			statement.setString(1, user.getPassword());
			statement.setString(2, user.getEmailid());
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

}

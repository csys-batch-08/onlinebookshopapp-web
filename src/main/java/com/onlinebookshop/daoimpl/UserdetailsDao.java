package com.onlinebookshop.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.onlinebookshop.dao.UserDetailsDao;
import com.onlinebookshop.model.Userdetails;
import com.onlinebookshop.util.Connectionutil;

public class UserdetailsDao implements UserDetailsDao {

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

			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
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
				user = new Userdetails(resultset.getInt("cus_id"), resultset.getString("name"),
						resultset.getLong("phoneNo"), resultset.getString("role"), resultset.getString("address"),
						emailid, password, resultset.getInt("wallet"));
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
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			if (resultset != null) {
				try {
					resultset.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
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
				user = new Userdetails(resultSet.getInt("cus_id"), resultSet.getString("name"),
						resultSet.getLong("phoneNo"), resultSet.getString("role"), resultSet.getString("address"),
						emailid, password, resultSet.getInt("wallet"));
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
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
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

			e.printStackTrace();

		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
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

			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
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

			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}

		}

	}

	public List<Userdetails> viewUser() {
		List<Userdetails> userList = new ArrayList<>();
		String show = "select cus_id,name,phoneNo,role,address,email_id,password,wallet from user_details where role!='admin'";
		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			con = Connectionutil.getDbConnection();
			statement = con.createStatement();
			resultSet = statement.executeQuery(show);
			while (resultSet.next()) {
				Userdetails user = new Userdetails(resultSet.getInt("cus_id"), resultSet.getString("name"),
						resultSet.getLong("phoneNo"), resultSet.getString("role"), resultSet.getString("address"),
						resultSet.getString("email_id"), resultSet.getString("password"), resultSet.getInt("wallet"));
				userList.add(user);
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
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
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
				Userdetails user = new Userdetails(resultSet.getInt("cus_id"), resultSet.getString("name"),
						resultSet.getLong("phoneNo"), resultSet.getString("role"), resultSet.getString("address"),
						resultSet.getString("email_id"), resultSet.getString("password"), resultSet.getInt("wallet"));
				userList.add(user);

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
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
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

			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
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

			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}
		return -1;
	}

	// update wallet:
	public boolean updatewallet(Userdetails userdetails) {

		String query = "update user_details set wallet = ? where email_id = ?";

		PreparedStatement statement = null;
		Connection con = null;
		try {
			con = Connectionutil.getDbConnection();
			statement = con.prepareStatement(query);
			statement.setInt(1, userdetails.getWallet());
			statement.setString(2, userdetails.getEmailid());
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
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
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
				Userdetails user = new Userdetails(resultSet.getString("name"), resultSet.getLong("phoneno"),
						resultSet.getString("address"), resultSet.getString("email_id"),
						resultSet.getString("password"), resultSet.getInt("wallet"));
				userList.add(user);
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
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
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

			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
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

			e.printStackTrace();

		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}

		}

	}

}

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

		
		Connection con =null;
		PreparedStatement statement = null;

		try {
			con =Connectionutil.getDbConnection();
			statement = con.prepareStatement(insertQuery);
			statement.setString(1, user.getName());
			statement.setLong(2, user.getPhoneNo());
			statement.setString(3, user.getAddress());
			statement.setString(4, user.getEmailid());
			statement.setString(5, user.getPassword());

			statement.executeUpdate();

		} catch (SQLException e) {

			e.getMessage();
		}finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.getMessage();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
				
					e.getMessage();
				}
			}
			
		}
	}

	// admin
	public Userdetails admin(String emailid, String password) {
		String adminQuery = "select cus_id,name,phoneNo,role,address,email_id,password,wallet from user_details where role='admin'and email_id='"
				+ emailid + "'and password='" + password + "'";

		Userdetails user = null;
		
		Connection con = null;
		ResultSet resultset = null;
		Statement statement = null;
		try {
			con = Connectionutil.getDbConnection();
			statement = con.createStatement();
			resultset = statement.executeQuery(adminQuery);
			if (resultset.next()) {
				user = new Userdetails(resultset.getInt(1), resultset.getString(2), resultset.getLong(3), resultset.getString(4), resultset.getString(5),
						emailid, password, resultset.getInt(8));
			}
		} catch (SQLException e) {

			e.getMessage();
		}finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.getMessage();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
				
					e.getMessage();
				}
			}
			if(resultset != null) {
				try {
					resultset.close();
				} catch (SQLException e) {
				
					e.getMessage();
				}
			}
		}
		return user;
	}

	// user
	public Userdetails validateUser(String emailid, String password) {
		String validateQuery = "select cus_id,name,phoneNo,role,address,email_id,password,wallet from user_details where email_id='"
				+ emailid + "' and password='" + password + "' and role='user' ";
		
		Userdetails user = null;
		
		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			con = Connectionutil.getDbConnection();
			statement = con.createStatement();
			resultSet = statement.executeQuery(validateQuery);
			if (resultSet.next()) {
				user = new Userdetails(resultSet.getInt(1), resultSet.getString(2), resultSet.getLong(3), resultSet.getString(4), resultSet.getString(5),
						emailid, password, resultSet.getInt(8));
			}

		} catch (SQLException e) {

			e.getMessage();

		}finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.getMessage();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
				
					e.getMessage();
				}
			}
			if(resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
				
					e.getMessage();
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

			e.getMessage();

		}finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.getMessage();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
				
					e.getMessage();
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

			e.getMessage();
		}finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.getMessage();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
				
					e.getMessage();
				}
			}
			
		}
	}

	public void activeUser(String delete) {
		String deleteQuery = "update user_details set role='user' where email_id=?";
		Connection con = null ;
		PreparedStatement statement = null;
		try {
			con = Connectionutil.getDbConnection();
			statement = con.prepareStatement(deleteQuery);
			statement.setString(1, delete);
			statement.executeUpdate();
			statement.execute("commit");
		} catch (SQLException e) {

			e.getMessage();
		}finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.getMessage();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
				
					e.getMessage();
				}
			}
			
		}

	}

	public List<Userdetails> viewUser() {
		List<Userdetails> userList = new ArrayList<>();
		String show = "select cus_id,name,phoneNo,role,address,email_id,password,wallet from user_details where role!='admin'";
		Connection con = null ;
		Statement statement = null;
	    ResultSet resultSet = null;
		try {
			con = Connectionutil.getDbConnection();
			statement = con.createStatement();
			resultSet = statement.executeQuery(show);
			while (resultSet.next()) {
				Userdetails user = new Userdetails(resultSet.getInt(1), resultSet.getString(2), resultSet.getLong(3), resultSet.getString(4),
						resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getInt(8));
				userList.add(user);
			}
		} catch (SQLException e) {

			e.getMessage();
		}finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.getMessage();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
				
					e.getMessage();
				}
			}
			if(resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
				
					e.getMessage();
				}
			}
		}
		return userList;
	}

	public List<Userdetails> viewParticularUser() {
		List<Userdetails> userList = new ArrayList<>();
		String show = "select select cus_id,name,phoneNo,role,address,email_id,password,wallet from user_details where role='user'";
		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			con = Connectionutil.getDbConnection();
			statement = con.createStatement();
            resultSet = statement.executeQuery(show);
			while (resultSet.next()) {
				Userdetails user = new Userdetails(resultSet.getInt(1), resultSet.getString(2), resultSet.getLong(3), resultSet.getString(4),
						resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getInt(8));
				userList.add(user);
			}
		} catch (SQLException e) {

			e.getMessage();
		}finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.getMessage();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
				
					e.getMessage();
				}
			}
			if(resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
				
					e.getMessage();
				}
			}
		}
		return userList;
	}

	public int findUserId(String emailId) {
		String findUser = "select cus_id from user_details where email_id='" + emailId + "'";
		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;
		int cusId = 0;
		try {
			con = Connectionutil.getDbConnection();
			statement = con.createStatement();
			resultSet = statement.executeQuery(findUser);
			if (resultSet.next()) {
				cusId = resultSet.getInt(1);
			}
		} catch (SQLException e) {

			e.getMessage();
		}finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.getMessage();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
				
					e.getMessage();
				}
			}
			if(resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
				
					e.getMessage();
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

			e.getMessage();
		}
		finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.getMessage();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
				
					e.getMessage();
				}
			}
			if(resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
				
					e.getMessage();
				}
			}
		}
		return -1;
	}

	// update wallet:
	public boolean updatewall(Userdetails userdetails) {

		
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

			e.getMessage();
		}finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.getMessage();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
				
					e.getMessage();
				}
			}
			
		}
		return true;
	}

	public List<Userdetails> myProfile(int userid) {
		List<Userdetails> userList = new ArrayList<>();
		String profile = "select name,phoneno,address,email_id,password,wallet from user_details where cus_id=?";
		Connection con =null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			con = Connectionutil.getDbConnection();
			statement = con.prepareStatement(profile);
			statement.setInt(1, userid);

			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Userdetails user = new Userdetails(resultSet.getString(1), resultSet.getLong(2), resultSet.getString(3), resultSet.getString(4),
						resultSet.getString(5), resultSet.getInt(6));
				userList.add(user);
			}
		} catch (SQLException e) {

			e.getMessage();
		}finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.getMessage();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
				
					e.getMessage();
				}
			}
			if(resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
				
					e.getMessage();
				}
			}
		}
		return userList;
	}

	public boolean refundWall(Userdetails userdetails) {

		
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

			e.getMessage();
		}finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.getMessage();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
				
					e.getMessage();
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

			e.getMessage();

		}finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.getMessage();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
				
					e.getMessage();
				}
			}
			
		}

	}

}

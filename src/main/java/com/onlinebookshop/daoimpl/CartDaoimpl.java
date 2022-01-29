package com.onlinebookshop.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.onlinebookshop.model.*;
import com.onlinebookshop.util.Connectionutil;

public class CartDaoimpl {

	public int insertcart(Cart cart) throws SQLException {
		int res = 0;
		
		if(cartexist(cart.getCusid(), cart.getBookid()) == false) {
		
			String insertQuery="insert into cart(book_id,cus_id)values(?,?)";
		    Connection con = null;
		    PreparedStatement statement = null ;
		try {
			con = Connectionutil.getDbConnection();
			statement = con.prepareStatement(insertQuery);
			statement.setInt(1, cart.getBookid());
			statement.setInt(2, cart.getCartid());
			res =  statement.executeUpdate();
			statement.executeUpdate("commit");
			
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
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
		return res ;
	}
	
	//cart exist:
		public boolean cartexist(int userid ,int bookid) {
			
			String query ="select cus_id,book_id from cart where cus_id in ? and book_id in ?";
			Connection con = null;
			PreparedStatement statement = null;
			ResultSet resultset = null;
			try {
				con = Connectionutil.getDbConnection();
				statement = con.prepareStatement(query);
				statement.setInt(1, userid);
				statement.setInt(2, bookid);
				resultset = statement.executeQuery();
				if(resultset.next()) {
					return true;
				}
			} catch (SQLException e) {
			  e.printStackTrace();
			}finally {
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
						resultset.close();
					} catch (SQLException e) {
					
						e.printStackTrace();
					}
				}
			}
			
			return false;
		}
	
	public List<ProductDetails> fetchCart(int cusid) {
		
		List<ProductDetails> booklist = new ArrayList<>();
		String query = "select b.book_id,b.category,b.description,b.book_title,b.book_code,b.price,b.publish_date,b.condition,NVL(a.name,'NOT AVAILABLE')as AuthorName,NVL(a.email_id,'NOT AVAILABLE'),b.bookimages from bookdetails b inner join author_details a on b.book_id = a.book_id left join cart c on b.book_id = c.book_id where c.cus_id = ?";
		Connection con = null; 
		ResultSet resultset = null;
		PreparedStatement statement = null;
		  Ratingdaoimpl ratingdaoimpl = new Ratingdaoimpl();
		  Rating rating = new Rating();
		  
		try {
			con = Connectionutil.getDbConnection();
			statement = con.prepareStatement(query);
			statement.setInt(1, cusid);
			
			resultset = statement.executeQuery();
			while(resultset.next()) {
				 
                rating.setBookid(resultset.getInt(1));
                double rate = ratingdaoimpl.fetchrating(rating);
				ProductDetails product = new ProductDetails(resultset.getInt(1),resultset.getString(2),resultset.getString(3),resultset.getString(4),resultset.getString(5),resultset.getInt(6),resultset.getDate(7).toLocalDate(),resultset.getString(8),resultset.getString(9),resultset.getString(10),rate,resultset.getString(11));
			    booklist.add(product);
			
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
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
					resultset.close();
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
			}
		}
		return booklist;	
	}
	
	public List<Cart> allCart() {
		List<Cart> cartList = new ArrayList<Cart>();
		String cart ="select cart_id,cus_id,book_id from cart";
		Connection con = null ;
		Statement statement = null;
		ResultSet resultset = null;
		try {
			con = Connectionutil.getDbConnection();
			statement =con.createStatement();
			resultset = statement.executeQuery(cart);
			while(resultset.next()) {
				Cart cartmodel = new Cart(resultset.getInt(1),resultset.getInt(2),resultset.getInt(3));
				cartList.add(cartmodel);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
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
					resultset.close();
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
			}
		}
		return cartList;
		

	}
	
	public int deleteCart(int bookid,int userid) {
		
		String delete="delete from cart where book_id=? and cus_id=?";
	    Connection con = null ;
		PreparedStatement statement=null;
		try {
			con = Connectionutil.getDbConnection();
			statement=con.prepareStatement(delete);
			statement.setInt(1, bookid);
			statement.setInt(2, userid);
			statement.executeUpdate();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
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
		return 0;
	}
}

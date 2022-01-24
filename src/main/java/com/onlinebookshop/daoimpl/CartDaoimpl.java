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
		//System.out.println(cartexist(cart.getCus_id(), cart.getBook_id()));
		
		if(cartexist(cart.getCus_id(), cart.getBook_id()) == false) {
		
			//System.out.println(cart.getCus_id() + "fvghjk" +cart.getBook_id());
		
			String insertQuery="insert into cart(book_id,cus_id)values(?,?)";
		Connection con = Connectionutil.getDbConnection();
		
		try {
			PreparedStatement pstm = con.prepareStatement(insertQuery);
			pstm.setInt(1, cart.getBook_id());
			pstm.setInt(2, cart.getCart_id());
			res =  pstm.executeUpdate();
			pstm.executeUpdate("commit");
			//System.out.println("Book added to cart");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return res ;
	}
	
	//cart exist:
		public boolean cartexist(int userid ,int bookid) throws SQLException {
			Connection con = Connectionutil.getDbConnection();
			String query ="select * from cart where cus_id in ? and book_id in ?";
			PreparedStatement pst =con.prepareStatement(query);
			pst.setInt(1, userid);
			pst.setInt(2, bookid);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				return true;
			}
			return false;
		}
	
	public List<ProductDetails> fetchCart(int cusid) {
		
		List<ProductDetails> booklist = new ArrayList<>();
		String Query = "select b.book_id,b.category,b.description,b.book_title,b.book_code,b.price,b.publish_date,b.condition,NVL(a.name,'NOT AVAILABLE')as AuthorName,NVL(a.email_id,'NOT AVAILABLE'),b.bookimages from bookdetails b left join author_details a on b.book_id = a.book_id  where b.book_id in (select c.book_id from cart c where c.cus_id = ?)";
		Connection con = Connectionutil.getDbConnection();
		try {
			PreparedStatement pstm = con.prepareStatement(Query);
			pstm.setInt(1, cusid);
	
			//System.out.println("usr" + cusid);
			
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				
				ProductDetails product = new ProductDetails(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getDate(7).toLocalDate(),rs.getString(8),rs.getString(9),rs.getString(10),0,rs.getString(11));
			    booklist.add(product);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return booklist;	
	}
	
	public List<Cart> allCart() {
		List<Cart> cartList = new ArrayList<Cart>();
		String cart ="select * from cart";
		Connection con = Connectionutil.getDbConnection();
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(cart);
			while(rs.next()) {
				Cart cartmodel = new Cart(rs.getInt(1),rs.getInt(2),rs.getInt(3));
				cartList.add(cartmodel);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cartList;
		

	}
	
	public int deleteCart(int bookid,int userid) {
		
		String delete="delete from cart where book_id=? and cus_id=?";
		Connection con = Connectionutil.getDbConnection();
		PreparedStatement pstm=null;
		try {
			pstm=con.prepareStatement(delete);
			pstm.setInt(1, bookid);
			pstm.setInt(2, userid);
			int noOfRows=pstm.executeUpdate();
			System.out.println(noOfRows+ "row deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}

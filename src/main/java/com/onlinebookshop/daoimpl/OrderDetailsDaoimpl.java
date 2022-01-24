package com.onlinebookshop.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.onlinebookshop.dao.OrderDetailsDao;
import com.onlinebookshop.model.Bookdetails;
import com.onlinebookshop.model.OrderDetails;
import com.onlinebookshop.model.Userdetails;
import com.onlinebookshop.util.Connectionutil;

public class OrderDetailsDaoimpl implements OrderDetailsDao{

	public void insertOrder(OrderDetails cart)
	{
		String insertQuery="insert into orderdetails(cus_id,book_id,quantity,total_cost) values(?,?,?,?)";
		Connection con = Connectionutil.getDbConnection();
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(insertQuery);
			pst.setInt(1, cart.getCus_id());
			pst.setInt(2, cart.getBook_id());
			pst.setInt(3, cart.getQuantity());
			pst.setDouble(4, cart.getTotal_cost());
			pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Value not inserted");
		}
	}

		
	public List<OrderDetails> viewOrder()
	{
		List<OrderDetails> orderList=new ArrayList<OrderDetails>();
		//String view ="select Category,Description,book_title,book_code,price,publish_date,condition,bookimages from bookdetails where book_id in (select book_id from orderdetails where cus_id in ?)";
		
		String view = "select cus_id,book_id,quantity,total_cost,order_date,status from orderdetails order by order_id desc";
		Connection con = Connectionutil.getDbConnection();
		try {
			Statement stm = con.createStatement();
			
			
			ResultSet rs = stm.executeQuery(view);
			while(rs.next())
			{
				//orderList.add(new Bookdetails(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getDate(6).toLocalDate(),rs.getString(7),rs.getString(8)));
				OrderDetails order = new OrderDetails(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getDouble(4),rs.getDate(5).toLocalDate(),rs.getString(6));
				orderList.add(order);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return orderList;
	}
	
	public int updateOrder(int quantity,int book_id)
	{
		String updateQuery="update orderdetails set quantity=? where book_id=?";
		Connection con = Connectionutil.getDbConnection();
		try {
			PreparedStatement pst=con.prepareStatement(updateQuery);
			pst.setInt(2, book_id);
			pst.setInt(1, quantity);
			int i=pst.executeUpdate();
			System.out.println(i+"row updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Try again");
		}
		return 0;
		
	}
	
	public int cancelOrder(int orderid) {
		
		
		String deleteOrder="update orderdetails set status='order canceled'  where order_id=?";
		Connection con = Connectionutil.getDbConnection();
		PreparedStatement pstm=null;
		try {
			pstm=con.prepareStatement(deleteOrder);
			pstm.setInt(1, orderid);
			int noOfRows=pstm.executeUpdate();
			pstm.executeUpdate("commit");
			System.out.println(noOfRows+ "row deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}
	
	//rating exist:
		public boolean OrderCancelled(String status ,int orderid) throws SQLException {
			Connection con = Connectionutil.getDbConnection();
			String query ="select * from rating where status='order canceled' and order_id in ?";
			PreparedStatement pst =con.prepareStatement(query);
			pst.setString(1, status);
			pst.setInt(2, orderid);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				return true;
			}
			return false;
		}
	
	public List<OrderDetails> viewUserOrder(int userid){
		
		List<OrderDetails> orderList=new ArrayList<OrderDetails>();
		String myCart ="select order_id,cus_id,book_id,quantity,total_cost,order_date,status from orderdetails where cus_id=? order by order_id desc";
		
		Connection con = Connectionutil.getDbConnection();
		try {
			PreparedStatement pstm = con.prepareStatement(myCart);
			pstm.setInt(1, userid);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				
				OrderDetails order = new OrderDetails(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getDouble(5),rs.getDate(6).toLocalDate(),rs.getString(7));
				orderList.add(order);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderList;
	}
	
	
	public int findOrderPrice(int orderid) {
		String find="select total_cost from orderdetails where order_id='"+orderid+"'";
		Connection con = Connectionutil.getDbConnection();
		int productId =0;
		try {
			Statement stm =con.createStatement();
			ResultSet rs=stm.executeQuery(find);
			if(rs.next())
			{
				productId=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productId;
		
	}
	
	public String findStatus(int orderid) {
		String find="select status from orderdetails where order_id='"+orderid+"'";
		Connection con = Connectionutil.getDbConnection();
		String status=null;
		try {
			Statement stm =con.createStatement();
			ResultSet rs=stm.executeQuery(find);
			if(rs.next())
			{
				 status=rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
		
	}
	
}
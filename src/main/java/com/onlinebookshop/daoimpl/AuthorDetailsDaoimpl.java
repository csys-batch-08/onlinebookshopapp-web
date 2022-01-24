package com.onlinebookshop.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.onlinebookshop.dao.AuthorDetailsDao;
import com.onlinebookshop.model.AuthorDetails;
import com.onlinebookshop.model.Bookdetails;
import com.onlinebookshop.util.Connectionutil;

public class AuthorDetailsDaoimpl implements AuthorDetailsDao {

	public void insertAuthor(AuthorDetails author)
	{
		String insert="insert into author_details(name,email_id,book_id)values(?,?,?)";
		Connection con = Connectionutil.getDbConnection();
		PreparedStatement pstm=null;
		try {
			pstm=con.prepareStatement(insert);
			pstm.setString(1, author.getName());
			pstm.setString(2, author.getEmail_id());
			pstm.setInt(3, author.getBook_id());
			pstm.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Try again");
		}
	}
	public void updateAuthor(String email_id,String name) {
		String updateQuery="update author_details set name=? where email_id=?";
		Connection con = Connectionutil.getDbConnection();
		try {
			PreparedStatement pst=con.prepareStatement(updateQuery);
			pst.setString(1, name);
			pst.setString(2, email_id);
			int i=pst.executeUpdate();
			System.out.println(i+"row updated");
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.out.println("Try again");
		}
	}
	public List<AuthorDetails> showAuthor()
	{
       List<AuthorDetails> authorList=new ArrayList<AuthorDetails>();
		
		String show = "select * from author_details";
		Connection con = Connectionutil.getDbConnection();
		try {
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery(show);
			while(rs.next())
			{
				AuthorDetails author = new AuthorDetails(rs.getString(2),rs.getString(3),rs.getInt(4));
				authorList.add(author);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return authorList;
	}
}

package com.onlinebookshop.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connectionutil {

	public static Connection getDbConnection() {
		Connection con = null;

		String password = "oracle";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			con = DriverManager.getConnection(url, "system", password);
		} catch (ClassNotFoundException e) {
			e.getMessage();
			
		} catch (SQLException e) {
			e.getMessage();
			
		}
		return con;
	}

	public void closeConnection(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if (rs != null) {
			rs.close();
		}
		if (pstmt != null) {
			pstmt.close();
		}
		if (con != null) {
			con.close();
		}
	}

}
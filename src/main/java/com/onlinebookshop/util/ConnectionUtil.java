package com.onlinebookshop.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.onlinebookshop.logger.Logger;

public class ConnectionUtil {
	private ConnectionUtil() {
		super();
	}

	public static Connection getDbConnection() {
		Connection con = null;

		try {
			EncryptAndDecrypt decryptpassword = new EncryptAndDecrypt();
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String  username = "system";
			String password = decryptpassword.decryt();
			con = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		}
		return con;
	}

	public static void closeConnection(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
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

	public static void closeConnection(PreparedStatement pstmt, Connection con) throws SQLException {

		if (pstmt != null) {
			pstmt.close();
		}
		if (con != null) {
			con.close();
		}
	}

}
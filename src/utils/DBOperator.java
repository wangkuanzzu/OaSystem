package utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBOperator {

	public static String driver;
	public static String url;
	public static String username;
	public static String password;
	static{
		Properties prop = new Properties();
		try {
			prop.load(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("db.properties"));
			DBOperator.driver = prop.getProperty("driver");
			DBOperator.url=prop.getProperty("url");
			DBOperator.username=prop.getProperty("username");
			DBOperator.password=prop.getProperty("password");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
}
	
	public static Connection getConnection() {
  	    Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	// 关闭数据库的方法
	public static void close(ResultSet rs, PreparedStatement ps, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

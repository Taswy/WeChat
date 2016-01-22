package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SelectByJdbc {
	private static Connection getConn() {
	    String driver = "com.mysql.jdbc.Driver";
	    String url = "jdbc:mysql://localhost:3306/mydb";
	    String username = "root";
	    String password = "123456";
	    Connection conn = null;
	    try {
	        Class.forName(driver); //classLoader,加载对应驱动
	        conn = (Connection) DriverManager.getConnection(url, username, password);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return conn;
	}
	public  static String getAll(String openid) {
		String result = null;
	    Connection conn = getConn();
	    String sql = "select weixin_tbl.message from weixin_tbl where openid =('"+openid+"');";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        int col = rs.getMetaData().getColumnCount();
	        while (rs.next()) {
	            result = rs.getString(col);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return result;
	}
	
	public  static String getdata(String id_weixin_tbl) {
		String result = null;
	    Connection conn = getConn();
	    String sql = "select weixin_tbl.message from weixin_tbl where id_weixin_tb =('"+id_weixin_tbl+"');";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        int col = rs.getMetaData().getColumnCount();
	        while (rs.next()) {
	            result = rs.getString(col);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return result;
	}
	
	public  static String getopenid(String id_weixin_tbl) {
		String result = null;
	    Connection conn = getConn();
	    String sql = "select weixin_tbl.openid from weixin_tbl where id_weixin_tb =('"+id_weixin_tbl+"');";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        int col = rs.getMetaData().getColumnCount();
	        while (rs.next()) {
	            result = rs.getString(col);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return result;
	}
}

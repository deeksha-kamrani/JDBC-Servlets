package com.ustglobal.jdbcapp;

import java.io.FileReader;
import java.sql.*;
import java.util.Properties;

public class InsertWithProperties {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		FileReader reader = null;

		try {
			reader = new FileReader("db.properties");
			Properties prop = new Properties();
			prop.load(reader);

			prop.getProperty("driver-class-name");

			String url = prop.getProperty("url");
			conn = DriverManager.getConnection(url, prop);

			String sql = prop.getProperty("insert-query");
			pstmt = conn.prepareStatement(sql);

			String empid = args[0];
			int id = Integer.parseInt(empid);
			pstmt.setInt(1,id);

			String name = args[1];
			pstmt.setString(2, name);

			String empsal = args[2];
			int sal = Integer.parseInt(empsal);
			pstmt.setInt(3,sal);

			String gender = args[3];
			pstmt.setString(4, gender);

			int count = pstmt.executeUpdate();

			System.out.println(count + " Row(s) inserted ");

		} catch (Exception e) {
			e.printStackTrace();	
		}	
		finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				if(pstmt!= null) {
					pstmt.close();
				}
				if(reader!=null) {
					reader.close();
				}
			}catch (Exception e) {
				e.printStackTrace();	
			}
		}				
	}
}

package com.ustglobal.empapp.dao;

import java.util.*;
import java.sql.*;

import com.ustglobal.empapp.dto.EmployeeBean;

public class EmployeeDAOImpl implements EmployeeDAO {

	public List<EmployeeBean> getAllEmployeeData() {

		String url="jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=tiger";
		String sql= "select * from employee_info";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(url);

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			ArrayList<EmployeeBean> result = new ArrayList<EmployeeBean>();
			
			while(rs.next()) {
				
				EmployeeBean bean = new EmployeeBean();
				
				int id = rs.getInt("id");
				bean.setId(id);
				
				String name = rs.getString("name");
				bean.setName(name);
				
				int sal = rs.getInt("sal");
				bean.setSal(sal);
				
				String gender = rs.getString("gender");
				bean.setGender(gender);

				result.add(bean);
				}// end of while loop
			return result;
			
		}catch (Exception e) {
				e.printStackTrace();
				return null;
			}finally {

				try {
					if(conn!=null) {
						conn.close();
					}if(stmt!=null) {
						stmt.close();
					}if(rs!=null) {
						rs.close();
					}
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}// try-catch-finally
		
			}// end of getAllEmployee
		
		public EmployeeBean searchEmployeeData(int id) {
			
			String url="jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=tiger";
			String sql= "select * from employee_info where id=?";
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				conn = DriverManager.getConnection(url);
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					EmployeeBean bean = new EmployeeBean();
					bean.setId(rs.getInt("id"));
					bean.setName(rs.getString("name"));
					bean.setSal(rs.getInt("sal"));
					bean.setGender(rs.getString("gender"));
					return bean;
					
				}else {
					return null;
				}
				
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}finally {
				try {
					if(conn!=null) {
						conn.close();
					}
					if(pstmt!=null) {
						pstmt.close();
					}
					if(rs!=null) {
						rs.close();
					}
 				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}// searchEmployeeData()		

		@Override
		public int insertEmployeeData(EmployeeBean bean) {
			return 0;
		}

		@Override
		public int updateEmployeeData(EmployeeBean bean) {
			return 0;
		}

		@Override
		public int deleteEmployeeData(int id) {
			return 0;
		}
}//

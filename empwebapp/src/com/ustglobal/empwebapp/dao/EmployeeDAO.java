package com.ustglobal.empwebapp.dao;

import com.ustglobal.empwebapp.dto.EmployeeInfoo;

public interface EmployeeDAO {

	public EmployeeInfoo auth(int id, String password);
	
	public EmployeeInfoo searchEmployee(int id);
	
	public boolean changePassword(int id, String password);
	
	public boolean registerEmployee(EmployeeInfoo info);
}

package com.ustglobal.empwebapp.servlets;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.ustglobal.empwebapp.dao.EmployeeDAO;
import com.ustglobal.empwebapp.dto.EmployeeInfoo;
import com.ustglobal.empwebapp.util.EmployeeDaoManager;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		EmployeeInfoo info = new EmployeeInfoo();
		info.setId(id);
		info.setName(name);
		info.setEmail(email);
		info.setPassword(password);

		EmployeeDAO dao = EmployeeDaoManager.getEmployeeDAO();
		boolean check = dao.registerEmployee(info);

		PrintWriter out = resp.getWriter();
		String msg = "";
		if(check) {
			msg = "Registration Completed";
			
		} else {
			msg = "Id cannot be repeated";
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("./login.jsp");
		dispatcher.forward(req, resp);
	}
}

package com.ustglobal.empwebapp.servlets;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.ustglobal.empwebapp.dto.EmployeeInfoo;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(false);
		if(session!=null) {
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/home.jsp");
			dispatcher.forward(req, resp);
			
		}else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
			dispatcher.forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

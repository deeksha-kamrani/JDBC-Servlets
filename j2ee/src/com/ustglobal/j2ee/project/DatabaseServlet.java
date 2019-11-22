package com.ustglobal.j2ee.project;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class DatabaseServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String empid = req.getParameter("empid");
	}

}

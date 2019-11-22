package com.ustglobal.webapp.servlets;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class CreateCookieServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Cookie cookie = new Cookie("emp-name", "Pari");
	cookie.setMaxAge(1000);
	resp.addCookie(cookie);
	PrintWriter out = resp.getWriter();
	out.println("<h1>Cookie Created</h1>");
	
	}

}

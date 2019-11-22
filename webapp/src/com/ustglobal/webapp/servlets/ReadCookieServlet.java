package com.ustglobal.webapp.servlets;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class ReadCookieServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Cookie[] cookies = req.getCookies();
		PrintWriter out = resp.getWriter();

		if(cookies==null) {
			out.println("<h1>No cookie found</h1>");
		}else {
			for(Cookie cookie : cookies) {
				String name = cookie.getName();
				if(name.equals("emp-name")) {
					out.println("<h1>Foe emp-name cookie value is");
					out.println(cookie.getValue());
					out.println("</h1>");
				}
			}
		}
	}
}
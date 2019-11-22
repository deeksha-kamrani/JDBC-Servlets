package com.ustglobal.webapp.servlets;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class FormServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("service-method");
		
		ServletContext context = getServletContext();
		String companyName = context.getInitParameter("company-name");
		
		ServletConfig config = getServletConfig();
		String batchName = config.getInitParameter("batch-name");
		
		String empName = req.getParameter("empname");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		
		out.println("<h1>");
		out.println(empName);
		out.println("</h1>");
		
		out.println("<h1>");
		out.println(email);
		out.println("</h1>");
		
		out.println("<h1>");
		out.println(password);
		out.println("</h1>");
		
		out.println("<h2>");
		out.println(companyName);
	    out.println("<h2>");
	    
	    out.println("<h2>");
		out.println(batchName);
	    out.println("<h2>");
		
		out.println("</body>");
		out.println("</html>");
	}
}
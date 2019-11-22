package com.ustglobal.webapp.servlets;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class ForwardServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     
		PrintWriter out = resp.getWriter();
		out.println("<body>");
		out.println("<html>");
		out.println("<h1>This is Forward Servlet</h1>");
		out.println("</body>");
		out.println("</html>");
     
     Object obj = new Object();
     req.setAttribute("obj", obj);
     
     RequestDispatcher dispatcher = 
    		 req.getRequestDispatcher("/first");
     
     dispatcher.forward(req, resp);
	}

}

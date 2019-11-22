package com.ustglobal.webapp.servlets;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

public class FormIncludeServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/form");
		dispatcher.forward(req, resp);
	}
}


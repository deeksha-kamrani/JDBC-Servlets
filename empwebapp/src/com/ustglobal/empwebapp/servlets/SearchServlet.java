package com.ustglobal.empwebapp.servlets;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.ustglobal.empwebapp.dao.EmployeeDAO;
import com.ustglobal.empwebapp.dto.EmployeeInfoo;
import com.ustglobal.empwebapp.util.EmployeeDaoManager;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		HttpSession session = req.getSession(false);
		
		if(session==null) {
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
			dispatcher.forward(req, resp);
		}else {
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		EmployeeDAO dao = EmployeeDaoManager.getEmployeeDAO();
		EmployeeInfoo info = dao.searchEmployee(id);
		
		req.setAttribute("info", info);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/search.jsp");
		dispatcher.forward(req, resp);
		
			/*
			 * PrintWriter out = resp.getWriter(); out.println("<html>");
			 * out.println("<body>"); out.println("<a href='./home'>Home</a>");
			 * out.println("<a style='float:right' href='./logout'>Logout</a>");
			 * 
			 * if(info!=null) {
			 * 
			 * out.println("<table align='center'>"); out.println("<tr>");
			 * out.println("<th>Id</th><th>Name</th><th>Email</th>"); out.println("</tr>");
			 * out.println("<tr>"); out.println("<td>"); out.println(info.getId());
			 * out.println("</td>"); out.println("<td>"); out.println(info.getName());
			 * out.println("</td>"); out.println("<td>"); out.println(info.getEmail());
			 * out.println("</td>"); out.println("</tr>"); out.println("</table>");
			 * 
			 * }else {
			 * 
			 * out.println("<h4>No Data Found</h4>"); }
			 * 
			 * out.println("</body>"); out.println("</html>");
			 */	
	}
	}
}
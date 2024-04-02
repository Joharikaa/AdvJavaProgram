package com.sathya.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EmployeeServlet() {
      
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt( request.getParameter("empid"));
		String name = request.getParameter("empname");
		int bs = Integer.parseInt(request.getParameter("empsalary"));
		
		
		double hra, da, pf;
		
		
		if (bs >= 50000) {
			
			hra= 0.30;
			da = 0.10;
			pf = 0.06;
		}
		else if ((bs< 50000) && (bs >= 25000)) {
			
			hra = 0.20;
			da = 0.05;
			pf = 0.03;	
		}
		else {
			hra = 0.10;
			da = 0.03;
			pf = 0.02;
		}
		
		double hraa = (hra*bs);
		double daa = (da*bs);
		double pfa = (pf * bs);
		
		double gs= (bs + hraa + daa - pfa);
		
		
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		writer.println("<html>");
		writer.println("<body bgcolor = pink");
		writer.println("<h1> <b>Employee Details...</h1></b>"+ "<br><br>");
		writer.println("Employee ID:"+id + "<br><br>");
		writer.println("Employee Name:"+name + "<br><br>");
		writer.println("Employee Basic Salary:"+bs + "<br><br>");
		writer.println("Employee HRA AMount:"+hraa + "<br><br>");
		writer.println("Employee DA Amount :"+daa + "<br><br>");
		writer.println("Employee Pf Amount:"+pfa + "<br><br>");
		writer.println("Employee Gross Salary:"+gs + "<br><br>");
		writer.println("</body>");
		writer.println("</html>");
		
	}

}

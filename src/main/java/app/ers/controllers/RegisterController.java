package app.ers.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.ers.dao.EmployeeDAO;
import app.ers.dao.EmployeeDAOImpl;
import app.ers.model.Employee;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String employeeId = request.getParameter("employeeid");
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String notification[] = request.getParameterValues("notification");
		String title = request.getParameter("title");
		String finalNotification = "";
		for (String temp: notification) {
			finalNotification += temp + ":";
		}
		
		Employee emp = new Employee(employeeId, firstName, lastName, username, password, gender, finalNotification, title);
		
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		employeeDAO.register(emp);
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		out.println("<html><body>");
		out.println("Welcome :" + username);
		out.println("<h1>You are registered successfully and your password is : " + password);
		out.println("<h1><a href=login.html>Login</a>");
		
		out.println("</body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

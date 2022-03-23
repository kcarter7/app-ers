package app.ers.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
       
	public String employeeId;
	public String firstName, lastName, username, password, gender, title;
	public String notifications[];
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
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Employee emp;
		EmployeeDAO employeeDAO;
		
		try {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			
			employeeId = request.getParameter("employeeId");
			firstName = request.getParameter("firstname");
			lastName = request.getParameter("lastname");
			username = request.getParameter("username");
			password = request.getParameter("password");
			gender = request.getParameter("gender");
			notifications = request.getParameterValues("notification");
			title = request.getParameter("title");
			String finalNotification = "";
			for (String temp: notifications) {
				finalNotification += temp + ":";
			}
			
			emp = new Employee(employeeId, firstName, lastName, username, password, gender, notifications[0], title);
			
			employeeDAO = new EmployeeDAOImpl();
			boolean result = employeeDAO.register(emp);
			if (result) {
				out.println("<html><body>");
				out.println("Welcome :" + username);
				out.println("<h1>You are registered successfully and your password is : " + password);
				out.println("<h1><a href=login.html>Login</a>");
				RequestDispatcher dispatcher = request.getRequestDispatcher("home.htnml");
				dispatcher.include(request, response);
			} else {
				out.println("<h1>Your username and password are incorrec please try again</h1>");
			}
		
			out.println("</body></html>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   // TODO document why this method is empty
	}

}

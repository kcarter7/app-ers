package app.ers.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import app.ers.model.Employee;
import app.ers.model.Reimbursement;
import app.ers.utility.DBConnection;

public class EmployeeDAOImpl implements EmployeeDAO {

	private static Logger logger = LogManager.getLogger(EmployeeDAOImpl.class);
	
	Connection connection = DBConnection.getConnection();
	
	@Override
	public boolean register(Employee emp) {
		System.out.println("###Adding Employee: " + emp);
		// Preparing database call.
		PreparedStatement statement = null;
		int rows = 0;
		
		// implementing connection and insertion of employee details
		try {
			statement = connection.prepareStatement("inset into employees values(?, ?, ?, ?, ?, ?, ?, ?)");
			statement.setString(1, emp.getEmployeeId());
			statement.setString(2, emp.getFirstName());
			statement.setString(3, emp.getLastName());
			statement.setString(4, emp.getUsername());
			statement.setString(5, emp.getPassword());
			statement.setString(6, emp.getGender());
			statement.setString(7, emp.getNotifications());
			statement.setString(8, emp.getTitle());
			
			rows = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (rows == 0)
			return false;
		else
			return true;
	}

	@Override
	public boolean validate(String username, String password) {
		System.out.println("###Validating employee with credentials :" + username  + " | " + password);
		
		// establishing variables to validate an employee.
		boolean userValid = false;
		PreparedStatement statement = null;
		
		/**
		 * establishing connection and selecting employees with username and password specified.
		 */
		try {
			statement = connection.prepareStatement("select * from employees where username = ? and password = ?");
			statement.setString(1, username);
			statement.setString(2, password);
			
			// executing query and returning whether process has been completed.
			ResultSet res = statement.executeQuery();
			userValid = res.next();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userValid;
	}

	@Override
	public List<Employee> getEmployees() {
		System.out.println("###Printing all employees :");
		List<Employee> employees = new ArrayList<Employee>();
		
		PreparedStatement statement = null;
		
		try {
			
			statement = connection.prepareStatement("select * from employees ;");
			ResultSet res = statement.executeQuery();
			while (res.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(res.getString(1));
				emp.setFirstName(res.getString(2));
				emp.setLastName(res.getString(3));
				emp.setUsername(res.getString(4));
				emp.setPassword(res.getString(5));
				emp.setGender(res.getString(6));
				emp.setNotifications(res.getString(7));
				emp.setTitle(res.getString(8));
				employees.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public List<Employee> getEmployeeByUserName(String username) {
		System.out.println("###Printing all employees with credentials : " + username);
		// preparing variables to retrieve employees with the entered username.
		List<Employee> employees = new ArrayList<Employee>();
		PreparedStatement statement = null;
		
		try {
			statement = connection.prepareStatement("select * from employees where username = ?");
			statement.setString(1, username);
			
			ResultSet res = statement.executeQuery();
			while (res.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(res.getString(1));
				emp.setFirstName(res.getString(2));
				emp.setLastName(res.getString(3));
				emp.setUsername(res.getString(4));
				emp.setPassword(res.getString(5));
				emp.setGender(res.getString(6));
				emp.setNotifications(res.getString(7));
				emp.setTitle(res.getString(8));
				employees.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employees;
	}

	@Override
	public boolean reimbursementRequest(int employeeId, Reimbursement reimbursement) {
		System.out.println("###Sending reimbursement request for employee :" );
		boolean sent = false;
		PreparedStatement statement = null;
		
		try {
			statement = connection.prepareStatement("insert into reimbursements values(?, ?, ?, ?");
			statement.setInt(1, employeeId);
			statement.setDouble(2, reimbursement.getAmount());
			statement.setString(3, reimbursement.getStatus());
			statement.setString(4, reimbursement.getPurpose());
			sent = statement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sent;
	}

	@Override
	public List<Reimbursement> viewPendingReimbursement(int employeeId, Reimbursement reimbursement) {
		System.out.println("###Viewing pending reimbursements");
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		PreparedStatement statement = null;
		ResultSet res = null;
		
		try {
			statement = connection.prepareStatement("select * from reimbursements where employeeId = ? and status = ?");
			statement.setInt(1, employeeId);
			statement.setString(2, "Pending");
			
			res = statement.executeQuery();
			
			reimbursement.setEmployeeId(employeeId);
			reimbursement.setAmount(res.getDouble(2));
			reimbursement.setStatus(res.getString(3));
			reimbursement.setPurpose(res.getString(4));
			reimbursements.add(reimbursement);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return reimbursements;
	}

	@Override
	public List<Reimbursement> viewResolveReimbursement(int employeeId, Reimbursement reimbursement) {
		System.out.println("###Viewing resolved reimbursements for :" + employeeId);
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		PreparedStatement statement = null;
		ResultSet res = null;
		
		try {
			statement = connection.prepareStatement("select * from reimbursements where employeeId = ? and status = ?");
			statement.setInt(1, employeeId);
			statement.setString(2, "Resolved");
			
			res = statement.executeQuery();
			
			reimbursement.setEmployeeId(employeeId);
			reimbursement.setAmount(res.getDouble(2));
			reimbursement.setStatus(res.getString(3));
			reimbursement.setPurpose(res.getString(4));
			
			reimbursements.add(reimbursement);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}

	@Override
	public List<Employee> viewEmployeeInfo(int employeeId) {
		System.out.println("###Viewing your employee info now");
		List<Employee> employees = new ArrayList<Employee>();
		PreparedStatement statement = null;
		ResultSet res = null;
		
		try {
			statement = connection.prepareStatement("select * from employees where employeeId = ?");
			statement.setInt(1, employeeId);
			res = statement.executeQuery();
			Employee emp = new Employee();
			
			while (res.next()) {
				emp.setEmployeeId(res.getString(1));
				emp.setFirstName(res.getString(2));
				emp.setLastName(res.getString(3));
				emp.setUsername(res.getString(4));
				emp.setPassword(res.getString(5));
				emp.setGender(res.getString(6));
				emp.setNotifications(res.getString(7));
				emp.setTitle(res.getString(8));
				employees.add(emp);
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employees;
	}

}

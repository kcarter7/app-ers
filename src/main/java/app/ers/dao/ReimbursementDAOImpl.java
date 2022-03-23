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

public class ReimbursementDAOImpl implements ReimbursementDAO {
	
	private static Logger logger = LogManager.getLogger(ReimbursementDAOImpl.class);
	
	Connection connection = DBConnection.getConnection();

	@Override
	public boolean submitReimbursement(int employeeId, double amount) {
		boolean sent = false;
		PreparedStatement statement = null;
		Reimbursement reimbursement = new Reimbursement();
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
	public boolean updateEmployeeInfo(Employee emp) {
		System.out.println("###Updating employee info with id: " + emp.getEmployeeId());
		PreparedStatement statement = null;
		ResultSet res = null;
		boolean done = false;
		
		try {
			statement = connection.prepareStatement("update employees set firstname = ? lastname = ? username = ? password = ? gender = ? notifications = ? title = ? where employeeId = ?");
			statement.setString(1, emp.getFirstName());
			statement.setString(2, emp.getLastName());
			statement.setString(3, emp.getUsername());
			statement.setString(4, emp.getPassword());
			statement.setString(5, emp.getGender());
			statement.setString(6, emp.getNotifications());
			statement.setString(7, emp.getTitle());
			
			res = statement.executeQuery();
			done = res.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return done;
	}

	@Override
	public boolean approveRequest(int employeeId, String status) {
		PreparedStatement statement = null;
		boolean approve = false;
		
		try {
			statement = connection.prepareStatement("update reimbursements set status = ? where employeeId = ?");
			statement.setString(1, status);
			statement.setDouble(2, employeeId);
			
			approve = statement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return approve;
	}

	@Override
	public boolean denyRequest(int employeeId, String status) {
		PreparedStatement statement = null;
		ResultSet res = null;
		boolean denied = false;
		
		try {
			statement = connection.prepareStatement("update reimbursements set status = ? where employeeId = ?");
			statement.setString(1, status);
			statement.setDouble(2, employeeId);
			res = statement.executeQuery();
			denied = res.next();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return denied;
	}

	@Override
	public List<Reimbursement> viewPendingReimburesments(String status) {
		PreparedStatement statement = null;
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		Reimbursement reimbursement = new Reimbursement();
		ResultSet res = null;
		
		try {
			statement = connection.prepareStatement("select * from reimbursements where status = ?");
			statement.setString(1, status);
			res = statement.executeQuery();
			
			while (res.next()) {
				reimbursement.setEmployeeId(res.getInt(1));
				reimbursement.setAmount(res.getDouble(2));
				reimbursement.setStatus(res.getString(3));
				reimbursement.setPurpose(res.getString(4));
				reimbursements.add(reimbursement);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}

	@Override
	public List<Reimbursement> viewApprovedReimbursements(String status) {
		PreparedStatement statement = null;
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		Reimbursement reimbursement = new Reimbursement();
		ResultSet res = null;
		
		try {
			statement = connection.prepareStatement("select * from reimbursements where status = ?");
			statement.setString(1, status);
			res = statement.executeQuery();
			
			while (res.next()) {
				reimbursement.setEmployeeId(res.getInt(1));
				reimbursement.setAmount(res.getDouble(2));
				reimbursement.setStatus(res.getString(3));
				reimbursement.setPurpose(res.getString(4));
				reimbursements.add(reimbursement);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}

	@Override
	public List<Employee> viewEmployeeInfo(int employeeId) {
		System.out.println("###Printing all employees :");
		List<Employee> employees = new ArrayList<Employee>();
		
		PreparedStatement statement = null;
		
		try {
			
			statement = connection.prepareStatement("select * from employees where employeeId = ? ;");
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
	public List<Employee> viewAllEmployees() {
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

}

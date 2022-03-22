package app.ers.dao;

import java.util.List;

import app.ers.model.Employee;
import app.ers.model.Reimbursement;

public interface ReimbursementDAO {

	public boolean submitReimbursement(int employeeId, double amount);
	public boolean updateEmployeeInfo(int employeeId);
	public boolean approveRequest(int employeeId, String status);
	public boolean denyRequest(int employeeId, String status);
	public List<Reimbursement> viewPendingReimburesments(String status);
	public List<Reimbursement> viewApprovedReimbursements(String status);
	public List<Employee> viewEmployeeInfo(int employeeId);
	public List<Employee> viewAllEmployees();
	
}

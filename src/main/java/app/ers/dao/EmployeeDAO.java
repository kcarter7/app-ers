package app.ers.dao;

import java.util.List;

import app.ers.model.Employee;
import app.ers.model.Reimbursement;

public interface EmployeeDAO {

	public boolean register(Employee emp);
	public boolean validate(String username, String password);
	public List<Employee> getEmployees();
	public List<Employee> getEmployeeByUserName(String username);
	public boolean reimbursementRequest(Reimbursement reimbursement);
	public List<Reimbursement> viewPendingReimbursement(int employeeId, String status);
	public List<Reimbursement> viewResolveReimbursement(int employeeId, String status);
	
}

package app.ers.dao;

import java.util.List;

import app.ers.model.Employee;
import app.ers.model.Reimbursement;

public class ReimbursementDAOImpl implements ReimbursementDAO {

	@Override
	public boolean submitReimbursement(int employeeId, double amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEmployeeInfo(int employeeId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean approveRequest(int employeeId, String status) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean denyRequest(int employeeId, String status) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Reimbursement> viewPendingReimburesments(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> viewApprovedReimbursements(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> viewEmployeeInfo(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> viewAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

}

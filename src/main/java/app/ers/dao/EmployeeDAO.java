package app.ers.dao;

import java.util.List;

import app.ers.model.Employee;

public interface EmployeeDAO {

	public boolean register(Employee emp);
	public boolean validate(String username, String password);
	public List<Employee> getEmployees();
	public List<Employee> getEmployeeByUserName(String username);
}

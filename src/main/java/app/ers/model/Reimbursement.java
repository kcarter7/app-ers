package app.ers.model;

import java.util.Objects;

public class Reimbursement {

	int employeeId;
	double amount;
	String status;
	String purpose;
	
	public Reimbursement() {
		
	}
	
	public Reimbursement(int employeeId, double amount, String status, String purpose) {
		this.employeeId = employeeId;
		this.amount = amount;
		this.status = status;
		this.purpose = purpose;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, employeeId, purpose, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
				&& employeeId == other.employeeId && Objects.equals(purpose, other.purpose)
				&& Objects.equals(status, other.status);
	}

	@Override
	public String toString() {
		return "Reimbursement [employeeId=" + employeeId + ", amount=" + amount + ", status=" + status + ", purpose="
				+ purpose + "]";
	}
	
	
	
}

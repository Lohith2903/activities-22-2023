package com.npci.LoanApplication.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="loan_application")
public class Loan_Application {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int applicationId;
	
	private int custId;
	
	
	private int loanId;
	
	private String status;

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public Loan_Application(int applicationId, int custId, int loanId, String status) {
		super();
		this.applicationId = applicationId;
		this.custId = custId;
		this.loanId = loanId;
		this.status = status;
	}

	public Loan_Application() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

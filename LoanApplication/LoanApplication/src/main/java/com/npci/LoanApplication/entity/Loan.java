package com.npci.LoanApplication.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="loan")
public class Loan {
	
	@Id
	//@OneToMany(cascade = CascadeType.ALL)
	//@JoinColumn(name="loan_id")
	private int loan_id;
	
	private String loan_type;

	public int getLoan_id() {
		return loan_id;
	}

	public void setLoan_id(int loan_id) {
		this.loan_id = loan_id;
	}

	public String getLoan_type() {
		return loan_type;
	}

	public void setLoan_type(String loan_type) {
		this.loan_type = loan_type;
	}

	public Loan(int loan_id, String loan_type) {
		super();
		this.loan_id = loan_id;
		this.loan_type = loan_type;
	}

	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}

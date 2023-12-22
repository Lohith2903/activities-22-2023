package com.npci.LoanApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


import com.npci.LoanApplication.dao.CustomerDao;
import com.npci.LoanApplication.entity.Customer;
import com.npci.LoanApplication.entity.Loan;
import com.npci.LoanApplication.entity.Loan_Application;


public interface Service {
	
	public Customer saveCustomer(Customer customer);
	
	public Loan_Application saveLoan(Loan_Application loan);
	
	//public Optional<Loan_Application> getLoanDetails(int id);
	
	public List<Customer> getByMailId(String email);
	
	public List<Loan> getAllLoans();
	
	public Loan getLoanType(int loanId);
	
	
	
}

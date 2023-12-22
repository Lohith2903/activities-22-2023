package com.npci.LoanApplication.service;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npci.LoanApplication.dao.CustomerDao;
import com.npci.LoanApplication.dao.LoanApplicationDao;
import com.npci.LoanApplication.dao.loanDao;
import com.npci.LoanApplication.entity.Customer;
import com.npci.LoanApplication.entity.Loan;
import com.npci.LoanApplication.entity.Loan_Application;

@Service
public class ServiceImpl implements com.npci.LoanApplication.service.Service {

	@Autowired
	private CustomerDao custDao;
	
	@Autowired
	private loanDao loanDao;
	
	@Autowired
	private LoanApplicationDao loanApplicationDao;
	
	public Customer saveCustomer(Customer customer) {
		Customer details = custDao.save(customer);
		
		return details;
	}

	@Override
	public Loan_Application saveLoan(Loan_Application loan) {
		// TODO Auto-generated method stub
		Loan_Application loans = loanApplicationDao.save(loan);
		return loans;
	}

	@Override
	public List<Customer> getByMailId(String email) {
		// TODO Auto-generated method stub
		return custDao.getByEmailId(email);
	}

	@Override
	public List<Loan> getAllLoans() {
		// TODO Auto-generated method stub
		
		List<Loan> loans = loanDao.findAll();
		System.out.println(loans);
		return loans;
	}

	@Override
	public Loan getLoanType(int loanId) {
		// TODO Auto-generated method stub
		Loan loan = loanDao.getById(loanId);
		return loan;
	}

	

}

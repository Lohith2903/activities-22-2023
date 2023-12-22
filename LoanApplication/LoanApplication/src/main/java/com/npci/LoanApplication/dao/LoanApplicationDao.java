package com.npci.LoanApplication.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.npci.LoanApplication.entity.Customer;
import com.npci.LoanApplication.entity.Loan_Application;

public interface LoanApplicationDao extends JpaRepository<Loan_Application, Integer> {
	


}

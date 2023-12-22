package com.npci.LoanApplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.npci.LoanApplication.entity.Loan;

public interface loanDao extends JpaRepository<Loan, Integer> {

}

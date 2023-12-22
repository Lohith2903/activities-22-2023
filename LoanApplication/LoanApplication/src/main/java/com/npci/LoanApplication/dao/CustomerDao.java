package com.npci.LoanApplication.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.npci.LoanApplication.entity.Customer;


public interface CustomerDao extends JpaRepository<Customer, Integer> {
	
	@Query("select p from Customer p where p.emailId=?1")
	public List<Customer> getByEmailId(String email);
}

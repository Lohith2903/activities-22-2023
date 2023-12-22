package com.npci.LoanApplication.controller;

import java.util.regex.Pattern;
import java.util.List;
import java.util.regex.Matcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.npci.LoanApplication.beans.ApplyLoan;
import com.npci.LoanApplication.beans.login;
import com.npci.LoanApplication.entity.Customer;
import com.npci.LoanApplication.entity.Loan;
import com.npci.LoanApplication.entity.Loan_Application;
import com.npci.LoanApplication.service.ServiceImpl;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class loginCheck {
	
	private static int userId;
	@Autowired
	private ServiceImpl service;

	public static boolean isValidEmail(String email) {
		// Define a simple pattern for email validation
		String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

		// Create a Pattern object
		Pattern pattern = Pattern.compile(emailRegex);

		// Create a matcher object
		Matcher matcher = pattern.matcher(email);

		// Return true if the email matches the pattern, false otherwise
		return matcher.matches();
	}

	public static boolean isValidPassword(String password) {
		// Define a pattern for strong password validation
		String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

		// Create a Pattern object
		Pattern pattern = Pattern.compile(passwordRegex);

		// Create a matcher object
		Matcher matcher = pattern.matcher(password);

		// Return true if the password matches the pattern, false otherwise
		return matcher.matches();
	}


	@PostMapping(path="/storeCustomer",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> storeApi(@RequestBody Customer customer){

//		if(customer.getFirstName().length() < 3 
//				||	customer.getLastName().length() < 1 
//				|| !isValidEmail(customer.getEmailId())
//				|| customer.getPan().equalsIgnoreCase("")
//				|| !isValidPassword(customer.getCustPassword())) {
//
//			return ResponseEntity.status(200).body("Please check the below validation and retry again for Registartion"
//					+ "Firstname: Minimum 3 characters\r\n"
//					+ "Lastname: Minimum 1 character\r\n"
//					+ "Email Id: Valid email id with . and @\r\n"
//					+ "Password: Strong passwords with atleast 8 characters having 1 digit, 1 uppercase, 1 lowercase & special characters mandatorily\r\n"
//					+ "Pan: Required\r\n"
//					+ "Phone: 10 digits phone number\r\n"
//					+ "");	
//		}
		return ResponseEntity.status(201).body(service.saveCustomer(customer));
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> LoginCheck(@RequestBody login data){
		List<Customer> customerList = service.getByMailId(data.getEmailId());
		userId = customerList.get(0).getCustId();
		System.out.println(customerList.size());
		if(customerList.size() == 1) {
			if(customerList.get(0).getCustPassword().equals(data.getPassword())) {
				return ResponseEntity.status(200).body("Logged In Successfully");
			}
			return ResponseEntity.status(200).body("Password is wrong!! Retry!!");
		}
		return ResponseEntity.status(200).body("check Mail Id and Password");
	}
	
	@GetMapping("/loans")
	public ResponseEntity<Object> AllLoans(){
		System.out.println("userId is:"+userId);
		List<Loan> loans = service.getAllLoans();
		
		return ResponseEntity.status(200).body(loans);
		
	}
	
	@PostMapping("/applyLoan")
	public ResponseEntity<Object> applyLoan(@RequestBody ApplyLoan apply ){
		System.out.println("userId is:"+userId);
		Loan_Application loans = new Loan_Application();
		loans.setCustId(userId);
		loans.setLoanId(apply.getLoanId());
		loans.setStatus("applied");
		Loan_Application applyLoan = service.saveLoan(loans);
		
		Loan loan = service.getLoanType(apply.getLoanId());
		String loanType = loan.getLoan_type();
		
		return ResponseEntity.status(200).body("Successfully applied for this loan:"+ loanType);
	}
	
	
	

}

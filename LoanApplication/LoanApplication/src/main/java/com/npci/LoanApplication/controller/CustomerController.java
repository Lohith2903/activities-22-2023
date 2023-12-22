//package com.npci.LoanApplication.controller;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.npci.LoanApplication.Exception.CustomerExceptions;
//import com.npci.LoanApplication.entity.Customer;
//import com.npci.LoanApplication.entity.Loan_Application;
//import com.npci.LoanApplication.service.ServiceImpl;
//
//
//
//
//
//@RestController
//@RequestMapping("/api")
//public class CustomerController {
//
//	@Autowired
//	private ServiceImpl service;
//
//	@PostMapping(path="/storeCustomer",consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Object> storeApi(@RequestBody Customer customer){
//
//		return ResponseEntity.status(201).body(service.saveCustomer(customer));
//
//	}
//
//	//	@GetMapping
//	//	public ResponseEntity<Object> fetchAll(){
//	//		try {
//	//			List<Customer> list=profileService.fetchProfiles();
//	//			return ResponseEntity.status(200).body(list);
//	//		}catch(CustomerExceptions e) {
//	//			String message=e.getMessage();
//	//			Map<String, String> error=new HashMap<>();
//	//			error.put("error", message);
//	//			return ResponseEntity.status(404).body(error);
//	//		}
//	//	}
//
//
//	@PostMapping(path="/storeLoans",consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Object> storeLoanApplication(@RequestBody Loan_Application loan){
//		
//		return ResponseEntity.status(201).body(service.saveLoan(loan));
//
//	}
//	
////	@GetMapping(path="/details/{id}")
////	public ResponseEntity<Object> fetchById(@PathVariable("id") int id){
////		Optional<Loan_Application> loans=service.getLoanDetails(id);
////		return ResponseEntity.status(200).body(loans);
////	}
//	
//	@PostMapping(path="/login",consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Object> login(@RequestParam("emailId") String emailId,@RequestParam("password") String password){
//		
//		return null;
//	}
//
//}

package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomersController {
	private CustomerService customerService;
	
	public CustomersController (CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	@GetMapping
	public List <Customer> getAllCustomers() {
		return (List<Customer>) customerService.getAllCustomers();
	}
	
	@PutMapping
	public List<Customer> updateCustomers(@RequestBody List<Customer> customerList) {
		return customerService.updateCustomers(customerList);
	}
	
	@PostMapping
	public List<Customer> saveCustomers (@RequestBody List<Customer> customer) {
		return customerService.saveCustomers(customer);
	}
	
	@DeleteMapping
	public void deleteCustomer(@RequestParam("customerId") int[] customerIds) {
		for(int i=0; i<customerIds.length; i++) {
			customerService.deleteCustomer(customerService.getCustomerById(customerIds[i]));
		}
	}
}


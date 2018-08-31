package com.example.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	private CustomerService customerService;
	
	public CustomerController (CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	@GetMapping("/{customerId}")
	public Customer getCustomer(@PathVariable ("customerId") int customerId) {
		return customerService.getCustomerById(customerId);
	}
	
	@PutMapping("/{customerId}")
	public Customer updateCustomer(@PathVariable ("customerId") int customerId, @RequestBody Customer customer) {
		return customerService.updateCustomer(customerId, customer);
	}
	
	@DeleteMapping("/{customerId}")
	public void deleteCustomer(@PathVariable ("customerId") int customerId) {
		customerService.deleteCustomer(customerService.getCustomerById(customerId));
	}
	
}

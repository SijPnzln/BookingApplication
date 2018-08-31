package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.demo.models.Customer;
import com.example.demo.repository.CustomerRepository;
@Transactional
public class CustomerService {
	private CustomerRepository customerRepository;
	
	public CustomerService(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}
	
	public List<Customer> getAllCustomers() {
		return (List<Customer>) customerRepository.findAll();
	}

	public List<Customer> saveCustomers(List<Customer> customerList) {
		return (List<Customer>) customerRepository.saveAll(customerList);
	}

	public Customer getCustomerById(int customerId) {
		return customerRepository.findById(customerId).get();
	}
	
	public void deleteCustomer(Customer customer) {
		customerRepository.delete(customer);
	}
	
	public Customer updateCustomer(int customerId, Customer customer) {
		if(customerRepository.existsById(customerId)) {
			customerRepository.save(customer);
		}
 		return customer;
	}
	
	public List<Customer> updateCustomers(List<Customer> customerList) {
		for(Customer customer: customerList) {
			if(customerRepository.existsById(customer.getCustomerId())) {
				customerRepository.save(customer);
			}
		}
 		return customerList;
	}

	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
}

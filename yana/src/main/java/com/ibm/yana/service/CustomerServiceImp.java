package com.ibm.yana.service;
import java.util.List;

import com.ibm.yana.model.Customer;
import com.ibm.yana.repository.CustomerRepository;
import com.ibm.yana.repository.CustomerRepositoryImpl;

public class CustomerServiceImp implements CustomerService{
	
	private static CustomerRepository customerRepository;
	
	static {
		customerRepository = new CustomerRepositoryImpl();
	}
	
	@Override
	public Customer createCustomer(Customer customer) throws Exception {
		// TODO Auto-generated method stub
		return customerRepository.createCustomer(customer);
	}
	@Override
	public List<Customer> getAllCustomer() throws Exception {
		// TODO Auto-generated method stub
		return customerRepository.getAllCustomer();
	}
	
}
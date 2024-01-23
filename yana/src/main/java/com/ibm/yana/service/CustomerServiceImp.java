package com.ibm.yana.service;
import java.util.List;

import com.ibm.yana.model.Customer;
import com.ibm.yana.repository.CustomerRepository;
import com.ibm.yana.repository.CustomerRepositoryImpl;

public class CustomerServiceImp implements CustomerService {

	
	private CustomerRepository customerRepo;
	
	{
		customerRepo= new CustomerRepositoryImpl();
	}
	@Override
	public Customer createCustomer(Customer customer) throws Exception{
		// TODO Auto-generated method stub
		return customerRepo.createCustomer(customer);
	}
	@Override
	public List<Customer> getAllCustomer() throws Exception {
		// TODO Auto-generated method stub
		return customerRepo.getAllCustomers();
	}
	@Override
	public Customer updateCustomer(String customerId) {
		// TODO Auto-generated method stub
		return customerRepo.updateCustomer(customerId);
	}
	@Override
	public void deleteCustomer(String customerId) {
		// TODO Auto-generated method stub
		customerRepo.deleteCustomer(customerId);
		
	}

}
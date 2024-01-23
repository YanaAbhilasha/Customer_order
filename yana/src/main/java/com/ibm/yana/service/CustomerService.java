package com.ibm.yana.service;

import java.util.List;

import com.ibm.yana.model.Customer;

public interface CustomerService {
	Customer createCustomer(Customer customer) throws Exception;
	List<Customer> getAllCustomer()throws Exception;
	Customer updateCustomer(String customerId);
	void deleteCustomer(String customerId);

}

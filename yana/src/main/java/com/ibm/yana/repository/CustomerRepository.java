package com.ibm.yana.repository;

import java.util.List;

import com.ibm.yana.model.Customer;

public interface CustomerRepository {
	Customer createCustomer(Customer customer) throws Exception;
	List<Customer> getAllCustomer() throws Exception;
}
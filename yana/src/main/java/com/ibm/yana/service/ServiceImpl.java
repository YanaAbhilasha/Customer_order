package com.ibm.yana.service;
import java.util.List;

import com.ibm.yana.model.Order;
import com.ibm.yana.repository.Repository;
import com.ibm.yana.repository.RepositoryImpl;

public class ServiceImpl implements Service {
	
	private Repository orderRepository;
	
	{
		orderRepository=new RepositoryImpl();
	}

	public Order createOrder(Order order) throws Exception {
		// TODO Auto-generated method stub
		return orderRepository.createOrder(order);
	}

	@Override
	public List<Order> getAllOrder() throws Exception {
		// TODO Auto-generated method stub
		return orderRepository.getAllOrder();
	}

}

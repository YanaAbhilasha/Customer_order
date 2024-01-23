package com.ibm.yana.service;
import java.util.List;

import com.ibm.yana.model.Order;
import com.ibm.yana.repository.Repository;
import com.ibm.yana.repository.RepositoryImpl;

public class ServiceImpl implements Service {
	
	private static Repository orderRepo;
	{
		orderRepo= new RepositoryImpl();
	}

	@Override
	public Order createOrder(Order order) throws Exception {
		// TODO Auto-generated method stub
		return orderRepo.createOrder(order);
	}

	@Override
	public List<Order> getAllOrders() throws Exception {
		// TODO Auto-generated method stub
		return orderRepo.getAllOrders();
	}

	@Override
	public Order updateOrder(String orderid) {
		// TODO Auto-generated method stub
		return orderRepo.updateOrder(orderid);
	}

	@Override
	public void deleteOrder(String orderId) {
		// TODO Auto-generated method stub
		  orderRepo.deleteOrder(orderId);
	}

}

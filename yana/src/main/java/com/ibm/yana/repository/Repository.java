package com.ibm.yana.repository;
import java.util.List;

import com.ibm.yana.model.Order;
public interface Repository {
	Order createOrder(Order order) throws Exception;
	List<Order> getAllOrder() throws Exception;
}

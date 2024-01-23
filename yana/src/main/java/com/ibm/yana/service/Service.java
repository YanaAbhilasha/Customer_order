package com.ibm.yana.service;
import java.util.List;

import com.ibm.yana.model.Order;
public interface Service {
	Order createOrder(Order order) throws Exception;
	List<Order> getAllOrders()throws Exception;
	Order updateOrder(String orderid);
	void deleteOrder(String orderId);

}

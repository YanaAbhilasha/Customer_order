package com.ibm.yana;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import com.ibm.yana.factory.MySessionFactory;
import com.ibm.yana.model.Customer;
import com.ibm.yana.model.Order;
import com.ibm.yana.service.CustomerService;
import com.ibm.yana.service.CustomerServiceImp;
import com.ibm.yana.service.Service;
import com.ibm.yana.service.ServiceImpl;

import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
	
	private static CustomerService customerService;
	private static Service orderService;
	private static SessionFactory sessionFactory;
	
	

	static {
		customerService = new CustomerServiceImp();
		orderService= new ServiceImpl();
		try {
			sessionFactory=MySessionFactory.getSessionFactory();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    public static void main( String[] args ) throws Exception
    {
    	//SessionFactory sessionfactory= new Configuration().configure().addAnnotatedClass(Order.class).addAnnotatedClass(Customer.class).buildSessionFactory();
//    	BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
//		Customer customer=new Customer();
    	
    	Session session= sessionFactory.openSession();
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    	
    	
// ---------------creating customer and order----------------------------------
    	session.beginTransaction();
    	
    	
    	Customer customer= new Customer();
    	Order order1= new Order();
    	Order order2= new Order();
    	
    	Order temporder1=orderService.createOrder(order1);
    	System.out.println(temporder1);
    	
    	Order temporder2=orderService.createOrder(order2);
    	System.out.println(temporder2);
    	
    	Customer tempcustomer=customerService.createCustomer(customer);
    	
    	
    	
    	tempcustomer.add(temporder1);
    	
    	
    	
    	tempcustomer.add(temporder2);
    	session.save(tempcustomer);
    	session.getTransaction().commit();
    	
    	
//    	//----updating order and customer--------------------------------

   	System.out.println("Enter customer id to update");
  	String cusid1= br.readLine();
  	Customer cus= customerService.updateCustomer(cusid1);
  	if(cus==null)
   	{
    		System.out.println("not found");
    	}
    	
    	System.out.println("Enter customer id to be deleted");
   	String cusid2 = br.readLine();
    	customerService.deleteCustomer(cusid2);
   	

    	
  	System.out.println("enter order id to be updated");
    	String orderid1= br.readLine();
   	
   	Order or1= orderService.updateOrder(orderid1);
   	
   	if(or1==null)
   	{
   		System.out.println("Order not found");
    	}
   	else {
    		System.out.println(or1);
    	}
    	

    	
   
    	
//    	System.out.println("Enter order id to be deleted");
    	
//    	String orderid2 = br.readLine(); 
//    	orderService.deleteOrder(orderid2);
    	
    	
    	
    	
    	
    	
//    	List<Customer> customers=customerService.getAllCustomer();
    	
//    	for(Customer c:customers)
//    	{
//    		System.out.println(c);
//    	}
    	
//    	List<Order> orders= orderService.getAllOrders();
    	
//    	for(Order o:orders)
//    	{
//    		System.out.println(o);
//    	}
			 
    }
}
package com.ibm.yana;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.ibm.yana.factory.MySessionFactory;
import com.ibm.yana.model.Customer;
import com.ibm.yana.model.Order;
import com.ibm.yana.service.CustomerService;
import com.ibm.yana.service.CustomerServiceImp;
import com.ibm.yana.service.Service;
import com.ibm.yana.service.ServiceImpl;
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
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
//		Customer customer=new Customer();
    	Customer customer= new Customer();
    	Order order1= new Order();
    	Order order2= new Order();
    	
    	Order temporder1=orderService.createOrder(order1);
    	System.out.println(temporder1);
    	
    	Order temporder2=orderService.createOrder(order2);
    	System.out.println(temporder2);
    	
    	Customer tempcustomer= customerService.createCustomer(customer);
    	
//    	tempcustomer.setOrder(temporder);
    	
//    	Session session= sessionFactory.openSession();
//    	session.beginTransaction();
    	tempcustomer.add(temporder1);
    	tempcustomer.add(temporder2);
    	
    	session.save(tempcustomer);
    	
    	session.getTransaction().commit();
    	    	
//    	for(Customer c:customerService.getCustomer())
//    	{
//    		System.out.println(c);
//    	}
			
    }
}
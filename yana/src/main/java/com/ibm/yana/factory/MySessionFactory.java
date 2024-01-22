package com.ibm.yana.factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ibm.yana.model.Customer;
import com.ibm.yana.model.Order;

public class MySessionFactory {
	
	private static SessionFactory sessionFactory;
	
	static
	{
		try {
			sessionFactory=new Configuration().configure().addAnnotatedClass(Order.class).addAnnotatedClass(Customer.class).buildSessionFactory();	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}

}

package com.ibm.yana.repository;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.UUID;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.ibm.yana.factory.MySessionFactory;
import com.ibm.yana.model.Customer;
public class CustomerRepositoryImpl implements CustomerRepository{
	BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
	
	private SessionFactory sessionFactory;
	private List<Customer> customerList;
	
	{
		try {
			sessionFactory=MySessionFactory.getSessionFactory();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public Customer createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		try {
			
			customer.setCustomerId(UUID.randomUUID().toString());
			
			 System.out.print("Enter customer Name: ");
			  customer.setCustomerName(bufferedReader.readLine());
			 
			
//			  System.out.println("enter customer order id: ");
//			  customer.s(bufferedReader.readLine());
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
//		Session session= sessionFactory.openSession();
//		session.getTransaction().begin();
//		session.persist(customer);
//		session.getTransaction().commit();
		return customer;
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		TypedQuery<Customer> typedQuery = session.createQuery("from Customer c", Customer.class);
		customerList = typedQuery.getResultList();
		return customerList;
	}

}
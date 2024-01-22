package com.ibm.yana.repository;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.UUID;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.ibm.yana.factory.MySessionFactory;
import com.ibm.yana.model.Order;
public class RepositoryImpl implements Repository {
	
	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	
	private SessionFactory sessionFactory;
	
	{
		try {
			sessionFactory=MySessionFactory.getSessionFactory();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public Order createOrder(Order order) {
		// TODO Auto-generated method stub
		try {
			
			order.setOrderId(UUID.randomUUID().toString());
			
			 System.out.print("Enter Order type: ");
			  order.setOrderType(br.readLine());
			 
			  System.out.println("enter order price: ");
			  order.setOrderPrice(Double.parseDouble(br.readLine()));
			 
			  System.out.println("enter is confirmed");
			  order.setIsConfirmed(Boolean.parseBoolean(br.readLine()));
			 
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
//		Session session= sessionFactory.openSession();
//		
//		session.getTransaction().begin();
//		session.persist(order);
//		session.getTransaction().commit();
		return order;
		
	}
	@Override
	public List<Order> getAllOrder(){
		// TODO Auto-generated method stub
		Session session =sessionFactory.openSession();
		
		TypedQuery<Order> query=session.createQuery("FROM Orders o",Order.class);
		
		return query.getResultList();
		
		
	}
}
















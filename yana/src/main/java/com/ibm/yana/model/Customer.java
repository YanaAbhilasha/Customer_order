package com.ibm.yana.model;

import javax.persistence.CascadeType;
import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="Customer")

public class Customer {
    @Id
    @Column(name="CustomerId")
    private String customerId;
    @Column(name="customerName")
    private String customerName;
   
//    @OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "CustomerOrderId")
    @OneToMany(mappedBy="customer", cascade= CascadeType.ALL)
    private List<Order> orders;
    
//    add convenience method for bi directional mapping
    public void add(Order temporder)
    {
    	if(orders==null)
    	{
    		orders=new ArrayList<Order>();
    	}
    	orders.add(temporder);
    	temporder.setCustomer(this);
    }
    
    
	
    
//    public Customer(String customerId, String customerName) {
//		super();
//		this.customerId = customerId;
//		this.customerName = customerName;
//		
//		
//	}


}
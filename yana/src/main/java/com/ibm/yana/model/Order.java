package com.ibm.yana.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="Orders")

public class Order {
    @Id
    @Column(name="OrderId")
    private String orderId;
    @Column(name="orderType")
    private String orderType;
    @Column(name="orderPrice")
    private double orderPrice;
    @Column(name="isConfirmed")
    private Boolean isConfirmed;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "customerId")
    private  Customer customer;
    
    
//    public Order(String orderId, String orderType, double orderPrice,Boolean isConfirmed ) {
//		super();
//		this.orderId = orderId;
//		this.orderType = orderType;
//		this.orderPrice = orderPrice;
//		this.isConfirmed = isConfirmed;
//		
//		
//	}
}
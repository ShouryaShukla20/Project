package com.cg.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="order_master")
//order is a keyword in SQL, so we have to give another name for it
//by using @Table annotation or by changing the class name here
public class Order
{
	@Id
	private int orderNo;
	private String customerName;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="product_orders", 
			joinColumns={@JoinColumn(name="orderNo")},
			inverseJoinColumns = {@JoinColumn(name="productNo")})
	Set<Product> products;

	public Order()
	{
		products = new HashSet<>();
	}
	
	public void addPorduct(Product product)
	{
		products.add(product);
	}
	
	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
}

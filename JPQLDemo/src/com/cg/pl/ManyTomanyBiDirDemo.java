package com.cg.pl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.entities.Order;
import com.cg.entities.Product;

public class ManyTomanyBiDirDemo
{
	public static void main(String[] args)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		
		Order o1 = new Order();
		o1.setOrderNo(199);
		o1.setCustomerName("Sandesh");
		Product p1 = new Product();
		p1.setProductNo(1);
		p1.setName("Sony LED TV");
		
		Product p2 = new Product();
		p2.setProductNo(2);
		p2.setName("Samsung Mobile J8");
		
		Product p3 = new Product();
		p3.setProductNo(3);
		p3.setName("LG Washing Machine");
		
		o1.addPorduct(p1);
		o1.addPorduct(p2);
		o1.addPorduct(p3);
		
		Order o2 = new Order();
		o2.setOrderNo(255);
		o2.setCustomerName("Chinku");
		Product p4 = new Product();
		p4.setProductNo(4);
		p4.setName("Lenovo ThinkPad");
		
		o2.addPorduct(p1);
		o2.addPorduct(p4);
		
		em.getTransaction().begin();
		em.persist(o1);
		em.persist(o2);
		em.getTransaction().commit();
		
		System.out.println("order and product added to DB");
	}
}

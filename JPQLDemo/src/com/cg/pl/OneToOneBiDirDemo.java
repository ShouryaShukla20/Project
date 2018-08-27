package com.cg.pl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.entities.Address;

public class OneToOneBiDirDemo
{
	public static void main(String[] args)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		
		Address address = em.find(Address.class, 1);
		
		address.setCity("Warangal");
		address.getStudent().setName("Rahul");
		
		em.getTransaction().begin();
		em.persist(address);
		em.getTransaction().commit();
		
		System.out.println(address);
	}
}

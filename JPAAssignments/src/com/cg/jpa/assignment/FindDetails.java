package com.cg.jpa.assignment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindDetails
{
	public static void main(String[] args)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		
		Author a1 = em.find(Author.class, 2);
		if(a1 != null)
		{
			System.out.println(a1);
		}
		else
		{
			System.out.println("No Object found !");
		}
	}
}
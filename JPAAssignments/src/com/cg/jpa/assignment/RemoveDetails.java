package com.cg.jpa.assignment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RemoveDetails
{
	public static void main(String[] args)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		
		Author a1 = em.find(Author.class, 2);
		if(a1 != null)
		{
			em.getTransaction().begin();
			em.remove(a1);
			em.getTransaction().commit();
		}
		else
		{
			System.out.println("No Object found !");
		}
	}
}

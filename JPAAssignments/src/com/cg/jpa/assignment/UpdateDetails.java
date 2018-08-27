package com.cg.jpa.assignment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UpdateDetails
{
	public static void main(String[] args)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		
		Author a1 = em.find(Author.class, 3);
		if(a1 != null)
		{
			a1.setFirstName("Ravi");
			a1.setMiddleName("Teja");
			a1.setLastName("Rallabandi");
			a1.setPhoneNo("8964810672");
			em.getTransaction().begin();
			em.merge(a1);
			em.getTransaction().commit();
		}
		else
		{
			System.out.println("No Object found !");
		}
	}
}

package com.cg.jpa.assignment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InsertDetails
{
	public static void main(String[] args)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		
		Author author1 = new Author();
		Author author2 = new Author();
		Author author3 = new Author();

		author1.setAuthorId(1);
		author1.setFirstName("Vamshi");
		author1.setMiddleName("Rao");
		author1.setLastName("Jupelli");
		author1.setPhoneNo("7032282283");
		
		author2.setAuthorId(2);
		author2.setFirstName("Sai");
		author2.setMiddleName("Krishna");
		author2.setLastName("Jupelli");
		author2.setPhoneNo("9505898741");
		
		author3.setAuthorId(3);
		author3.setFirstName("Dinesh");
		author3.setMiddleName("Rao");
		author3.setLastName("Gandra");
		author3.setPhoneNo("9993686455");
		
		em.getTransaction().begin();
		em.persist(author1);
		em.persist(author2);
		em.persist(author3);
		em.getTransaction().commit();
	}
}

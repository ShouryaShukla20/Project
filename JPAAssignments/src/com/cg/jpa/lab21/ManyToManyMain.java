package com.cg.jpa.lab21;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManyToManyMain
{
	public static void main(String[] args)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		
		AuthorNew a1 = new AuthorNew();
		a1.setAuthorId(101);
		a1.setAuthorName("Amish Tripathi");
		
		Book b1 = new Book();
		b1.setBookISBN(4517);
		b1.setBookTitle("Scion of Ikshvanku");
		b1.setBookPrice(620);
		
		Book b2 = new Book();
		b2.setBookISBN(4124);
		b2.setBookTitle("Sita of Mithila");
		b2.setBookPrice(720);
		
		Book b3 = new Book();
		b3.setBookISBN(4632);
		b3.setBookTitle("Immortal India");
		b3.setBookPrice(350);
		
		a1.addPorduct(b1);
		a1.addPorduct(b2);
		a1.addPorduct(b3);
		
		AuthorNew a2 = new AuthorNew();
		a2.setAuthorId(102);
		a2.setAuthorName("Deep Trivedi");
		
		Book b4 = new Book();
		b4.setBookISBN(3412);
		b4.setBookTitle("I am the Mind");
		b4.setBookPrice(230);
		
		Book b5 = new Book();
		b5.setBookISBN(3621);
		b5.setBookTitle("I am Krishna");
		b5.setBookPrice(810);
		
		a2.addPorduct(b4);
		a2.addPorduct(b5);
		
		AuthorNew a3 = new AuthorNew();
		a3.setAuthorId(103);
		a3.setAuthorName("Paulo Ceolho");
		
		Book b6 = new Book();
		b6.setBookISBN(2164);
		b6.setBookTitle("The Alchemist");
		b6.setBookPrice(930);
		
		a3.addPorduct(b6);
		
		Book b7 = new Book();
		b7.setBookISBN(1654);
		b7.setBookTitle("The Real Life MBA");
		b7.setBookPrice(850);
		
		AuthorNew a4 = new AuthorNew();
		a4.setAuthorId(104);
		a4.setAuthorName("Jack Syelvch");
		
		a4.addPorduct(b7);
		
		AuthorNew a5 = new AuthorNew();
		a5.setAuthorId(105);
		a5.setAuthorName("Suez Syelvch");
		
		a5.addPorduct(b7);
		
		em.getTransaction().begin();
		em.persist(a1);
		em.persist(a2);
		em.persist(a3);
		em.persist(a4);
		em.persist(a5);
		em.getTransaction().commit();
		
		System.out.println("Authors and Books added to DB");
	}
}

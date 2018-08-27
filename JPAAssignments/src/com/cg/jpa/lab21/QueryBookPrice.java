package com.cg.jpa.lab21;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class QueryBookPrice
{
	public static void main(String[] args)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		
		String sql1="select book from Book book where book.bookPrice>500";
		Query query1 = em.createQuery(sql1);
		List<Book> booklist = query1.getResultList();
		
		System.out.println("------------------------------------------");
		for(Book b : booklist)
		{
			System.out.println(b.getBookISBN() + " " + b.getBookTitle() + " " + b.getBookPrice());
		}
	}
}
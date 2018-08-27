package com.cg.jpa.lab21;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class QueryBookId
{
	public static void main(String[] args)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();

		String sql1="select book from Book book where book.bookISBN= :isbn";
		TypedQuery<Book> query1 = em.createQuery(sql1, Book.class);
		query1.setParameter("isbn", 2164);
		List<Book> booklist = query1.getResultList();
		
		for(Book b : booklist)
		{
			System.out.println("---------------------------------");
			System.out.println(b.getBookISBN() + " " + b.getBookTitle() + " " + b.getBookPrice());
		}

	}
}

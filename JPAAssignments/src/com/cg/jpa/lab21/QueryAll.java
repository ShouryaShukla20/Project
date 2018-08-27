package com.cg.jpa.lab21;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class QueryAll
{
	public static void main(String[] args)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		
		String sql1="select book from Book book";
		Query query1 = em.createQuery(sql1);
		List<Book> booklist = query1.getResultList();
		
		String sql2="select author from AuthorNew author";
		Query query2 = em.createQuery(sql2);
		List<AuthorNew> authorlist = query2.getResultList();
		
		for(Book b : booklist)
		{
			System.out.println(b.getBookISBN() + " " + b.getBookTitle() + " " + b.getBookPrice());
		}
		
		System.out.println("-------------------------------");
		
		for(AuthorNew a : authorlist)
		{
			System.out.println(a.getAuthorId() + " " + a.getAuthorName());
		}
		
		
	}
}

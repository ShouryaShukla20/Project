package com.cg.pl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cg.entities.Student;

public class NamedQueryDemo
{
	public static void main(String[] args)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		
		/*TypedQuery<Integer> query = em.createNamedQuery("getHighestMarks",Integer.class);
		int max=query.getSingleResult();
		System.out.println("Highest Marks : " +max);*/
		
		TypedQuery<String> query = em.createNamedQuery("nameList", String.class);
		query.setParameter("marks", 70);
		List<String> names = query.getResultList();
		for(String name : names)
		{
			System.out.println(name);
		}
	}
}

package com.cg.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainNew {

	public static void main(String[] args)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		
	/*	Student s1 = em.find(Student.class, 1);
		Student s2 = em.find(Student.class, 2);
		
		System.out.println(s1.getName());
		System.out.println(s1.getAddress());
		System.out.println(s1.getTotalMarks());
		
		System.out.println();
		
		System.out.println(s2.getName());
		System.out.println(s2.getAddress());
		System.out.println(s2.getTotalMarks());*/
		
		/*em.getTransaction().begin();
		Student stud;
		stud = em.find(Student.class,  2);
		if(stud!=null)
		{
			em.remove(stud);
			em.getTransaction().commit();
			System.out.println("Removed");
		}*/
		
	/*	em.getTransaction().begin();
		Student s;
		s = em.find(Student.class, 1);
		s.setAddress("Chennai");
		s.setName("Vamshi Rao");
		em.merge(s);
		em.getTransaction().commit();
		System.out.println("Record updated");*/
	}
}

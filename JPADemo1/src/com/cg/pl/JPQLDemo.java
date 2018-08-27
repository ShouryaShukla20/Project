package com.cg.pl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cg.entities.Student;


public class JPQLDemo
{
	public static void main(String[] args)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		
		String sql="select stud from Student stud where stud.totalMarks>70";
		Query query = em.createQuery(sql);
		List<Student> studList = query.getResultList();
		for(Student s : studList)
		{
			System.out.println(s.getName() + " " + s.getTotalMarks());
		}
	}
}

package com.cg.pl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.cg.entities.Student;


public class JPQLDemo1
{
	public static void main(String[] args)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		
		String sql="select stud from Student stud where stud.totalMarks> :marks";
		/*Query query = em.createQuery(sql);
		List<Student> studList = query.getResultList();*/
		
		TypedQuery<Student> query = em.createQuery(sql, Student.class);
		query.setParameter("marks", 40);
		List<Student> studList = query.getResultList();
		for(Student s : studList)
		{
			System.out.println(s.getName() + " " + s.getTotalMarks());
		}
	}
}

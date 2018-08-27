package com.cg.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main
{
	public static void main(String[] args)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		
		Student student = new Student();
		student.setRollno(1);
		student.setName("Vamshi");
		student.setTotalMarks(80);
		student.setAddress("Hyderabad");
		
		student.setRollno(3);
		student.setName("Dinesh");
		student.setTotalMarks(65);
		student.setAddress("Pune");
		
		student.setRollno(4);
		student.setName("Krishna");
		student.setTotalMarks(95);
		student.setAddress("Raipur");
	}
}

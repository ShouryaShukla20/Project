package com.cg.pl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.entities.Address;
import com.cg.entities.Student;

public class OneToOneUniDirDemo
{
	public static void main(String[] args)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		
	/*	Address address = new Address();
		address.setAddressId(1);
		address.setStreetName("Talawade Road");
		address.setCity("Pune");
		address.setZipcode("411034");
		
		Student student = new Student();
		student.setRollno(10);
		student.setName("Utkarsh");
		student.setAddress(address);
		
		Address address1 = new Address();
		address1.setAddressId(2);
		address1.setStreetName("Amanaka");
		address1.setCity("Raipur");
		address1.setZipcode("492010");
		
		Student student1 = new Student();
		student1.setRollno(11);
		student1.setName("Uttej");
		student1.setAddress(address1);
		
		em.getTransaction().begin();
		em.persist(student);
		em.persist(student1);
		em.getTransaction().commit();*/
		System.out.println("student and address saved to DB");
		
		Student student = em.find(Student.class, 10);
		student.setName("Vamshi");
		student.getAddress().setCity("Mumbai");
		em.getTransaction().begin();
		em.merge(student);
		em.getTransaction().commit();
		
		System.out.println(student);
	}
}

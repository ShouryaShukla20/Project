package com.cg.inh.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InheritanceDemo
{
	public static void main(String[] args)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager sm = emf.createEntityManager();
		
		EmployeeNew emp1 = new EmployeeNew();
		emp1.setEmpid(1);
		emp1.setName("Mahima");
		emp1.setSalary(34000);
		
		Manager mgr = new Manager();
		mgr.setEmpid(2);
		mgr.setName("Veena");
		mgr.setSalary(36475);
		mgr.setRating(5);
		mgr.setDailyAllow(1200);
		
		sm.getTransaction().begin();
		sm.persist(emp1);
		sm.persist(mgr);
		sm.getTransaction().commit();
		System.out.println("Employee and mgr persisted...");
	}
}

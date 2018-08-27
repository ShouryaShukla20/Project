package com.cg.pl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.entities.Department;
import com.cg.entities.Employee;

public class OneToManyBiDirDemo
{
	public static void main(String[] args)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();

		Department dept = new Department();
		dept.setDeptNo(1);
		dept.setName("Admin");
		
		Employee e1 = new Employee();
		e1.setEmpid(12);
		e1.setName("Reddi");
		
		Employee e2 = new Employee();
		e2.setEmpid(13);
		e2.setName("Sadik");
//		e2.setDepartment(dept);
		
		Employee e3 = new Employee();
		e3.setEmpid(14);
		e3.setName("Bhuvi");
//		e3.setDepartment(dept);
		
		dept.addEmployee(e1);
		dept.addEmployee(e2);
		dept.addEmployee(e3);
		
		em.getTransaction().begin();
		em.persist(dept);
//		em.persist(e2);
		
		em.persist(e3);
		em.getTransaction().commit();
		
		System.out.println("Emp and Dept added to DB");
		
	}
}

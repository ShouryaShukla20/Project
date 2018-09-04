package com.cg;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;



@Repository
@EnableTransactionManagement
public class InMemoryPersonDetailsImpl implements PersonDetailsDAO{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Person> findAll(){
//		Person person=new Person();
//		person.setAge(25);
//		person.setId(1);
//		person.setName("Rahul");
//		
//		List<Person> persons=new LinkedList<>();
//		persons.add(person);
//		return persons;
		Query query=em.createQuery("Select p from Person p");
		List<Person> list = query.getResultList();
		return list;
	}

	@Override
	@Transactional
	public void create(Person p) {
		System.out.println("----");
		em.persist(p);
		System.out.println("congratulations! your account has been created");
		// TODO Auto-generated method stub
		
	}

	@Override
	public Person findbyid(int id) {
		// TODO Auto-generated method stub
		Query query=em.createQuery("Select p from Person p where p.id= "+id);
		Person p=(Person) query.getSingleResult();
		return p;
	
	}

	@Override
	@Transactional	
	public void update(Person p) {
		em.merge(p);
//		entityManager.merge(car);
//		Query query=em.createQuery("Update Person p set(p.name,p.age) values("+p.getName()+","+p.getAge()+")");
//		query.executeUpdate();
		// TODO Auto-generated method stub
		
	}

}

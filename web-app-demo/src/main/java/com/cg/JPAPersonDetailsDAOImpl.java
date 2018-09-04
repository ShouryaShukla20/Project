package com.cg;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Repository
@EnableTransactionManagement
public class JPAPersonDetailsDAOImpl implements PersonDetailsDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Person> findAll() {
		System.out.println("in jpa");
		Query query = entityManager.createQuery("select person from Person person");
		return query.getResultList();
	}

	@Override
	@Transactional
	public void addPerson(Person person) {
		entityManager.persist(person);
		System.out.println("add hogya");
	}

	@Override
	public Person findById(int id) {
		Person person = entityManager.find(Person.class, id);
		return person;
	}

	@Override
	@Transactional
	public void updatePerson(Person person) {
		EntityTransaction tx = entityManager.getTransaction();
		try {
			tx.begin();
			Person personnew = entityManager.find(Person.class, person.getId());
			personnew.setName(person.getName());
			personnew.setAge(person.getAge());
			entityManager.merge(person);
			tx.commit();
		}
		catch(RuntimeException e) {
			tx.rollback();
			throw e;
		}
	}
	
	

}

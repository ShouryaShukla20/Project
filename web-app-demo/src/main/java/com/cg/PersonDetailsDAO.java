package com.cg;

import java.util.List;

public interface PersonDetailsDAO {
	
	public List<Person> findAll();
	public void addPerson(Person person);
	public Person findById(int id);
	public void updatePerson(Person person);
}

package com.cg;

import java.util.List;

public interface PersonDetailsDAO {

	public List<Person> findAll();
	public void create(Person p);
	public Person findbyid(int id);
	public void update(Person p);
}

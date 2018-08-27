package com.cg.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

@Entity
public class Student
{
	@Id
	private int rollno;
	private String name;
	@JoinColumn(name="addressId")
	@OneToOne(cascade=CascadeType.ALL)
	private Address address;
	
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return  rollno + ", "+ name + ", " + address;
	}
	
	
}

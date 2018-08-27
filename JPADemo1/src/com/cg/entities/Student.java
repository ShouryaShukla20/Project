package com.cg.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries
({
@NamedQuery(name="getStudList",query="select stud from Student stud"),
@NamedQuery(name="nameList",query="select stud.name from Student stud where stud.totalMarks> :marks"),
@NamedQuery(name="getHighestMarks",query="select max(stud.totalMarks) from Student stud")
})
public class Student
{
	@Id
	private int rollno;
	private String name;
	private int totalMarks;
	private String address;
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
	public int getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}

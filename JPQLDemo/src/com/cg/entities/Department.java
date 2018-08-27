package com.cg.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department
{
	@Id
	private int deptNo;
	private String name;
	
	@OneToMany(mappedBy="department",cascade=CascadeType.ALL)
	Set<Employee> employees;
	
	public Department()
	{
		employees = new HashSet<>();
	}
	
	public void addEmployee(Employee emp)
	{
		emp.setDepartment(this);
		employees.add(emp);
	}
	
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}

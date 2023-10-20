package com.amdocs.employee.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee{
	
	@Id
	private int emp_Id;
	private String Name; 
	private String Number; 
	private String Role;
	
	public Employee() {
		super();
	}

	public Employee(int emp_Id, String name, String number, String role) {
		super();
		this.emp_Id = emp_Id;
		Name = name;
		Number = number;
		Role = role;
	}

	public int getEmp_Id() {
		return emp_Id;
	}

	public void setEmp_Id(int emp_Id) {
		this.emp_Id = emp_Id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getNumber() {
		return Number;
	}

	public void setNumber(String number) {
		Number = number;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	@Override
	public String toString() {
		return "Employee [emp_Id=" + emp_Id + ", Name=" + Name + ", Number=" + Number + ", Role=" + Role + "]";
	}
		

}

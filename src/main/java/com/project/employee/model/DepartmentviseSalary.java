package com.project.employee.model;

public class DepartmentviseSalary {

	private String department;
	private int salary;
	public DepartmentviseSalary() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DepartmentviseSalary(String department, int salary) {
		super();
		this.department = department;
		this.salary = salary;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
}

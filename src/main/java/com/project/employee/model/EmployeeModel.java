package com.project.employee.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EmployeeModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int emid;
	private String name;
	private String email;
	private String department;
	private double salary;
	private LocalDate dateofjoin;
	public EmployeeModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeModel(int emid, String name, String email, String department, double salary, LocalDate dateofjoin) {
		super();
		this.emid = emid;
		this.name = name;
		this.email = email;
		this.department = department;
		this.salary = salary;
		this.dateofjoin = dateofjoin;
	}
	public int getEmid() {
		return emid;
	}
	public void setEmid(int emid) {
		this.emid = emid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public LocalDate getDateofjoin() {
		return dateofjoin;
	}
	public void setDateofjoin(LocalDate dateofjoin) {
		this.dateofjoin = dateofjoin;
	}
	
		
}

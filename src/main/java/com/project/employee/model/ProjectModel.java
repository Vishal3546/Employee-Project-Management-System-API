package com.project.employee.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProjectModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int prid;
	private String projectname;
	private String clientname;
	private LocalDate startdate;
	private LocalDate enddate;
	private double budget;
	public ProjectModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProjectModel(int prid, String projectname, String clientname, LocalDate startdate, LocalDate enddate,
			double budget) {
		super();
		this.prid = prid;
		this.projectname = projectname;
		this.clientname = clientname;
		this.startdate = startdate;
		this.enddate = enddate;
		this.budget = budget;
	}
	public int getPrid() {
		return prid;
	}
	public void setPrid(int prid) {
		this.prid = prid;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	public String getClientname() {
		return clientname;
	}
	public void setClientname(String clientname) {
		this.clientname = clientname;
	}
	public LocalDate getStartdate() {
		return startdate;
	}
	public void setStartdate(LocalDate startdate) {
		this.startdate = startdate;
	}
	public LocalDate getEnddate() {
		return enddate;
	}
	public void setEnddate(LocalDate enddate) {
		this.enddate = enddate;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	
		
}

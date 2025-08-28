package com.project.employee.model;

public class AssignProjectReport {

	private String projectname;
	private String name;
	public AssignProjectReport() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AssignProjectReport(String projectname, String name) {
		super();
		this.projectname = projectname;
		this.name = name;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}

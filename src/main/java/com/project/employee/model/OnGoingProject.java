package com.project.employee.model;

import java.util.ArrayList;

public class OnGoingProject {

	private String projectname;
	private ArrayList<String> names;
	public OnGoingProject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OnGoingProject(String projectname, ArrayList<String> names) {
		super();
		this.projectname = projectname;
		this.names = names;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	public ArrayList<String> getNames() {
		return names;
	}
	public void setNames(ArrayList<String> names) {
		this.names = names;
	}
	
	
}

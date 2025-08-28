package com.project.employee.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AssignmentModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int assid;
	private int emid;
	private int prid;
	public AssignmentModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AssignmentModel(int assid, int emid, int prid) {
		super();
		this.assid = assid;
		this.emid = emid;
		this.prid = prid;
	}
	public int getAssid() {
		return assid;
	}
	public void setAssid(int assid) {
		this.assid = assid;
	}
	public int getEmid() {
		return emid;
	}
	public void setEmid(int emid) {
		this.emid = emid;
	}
	public int getPrid() {
		return prid;
	}
	public void setPrid(int prid) {
		this.prid = prid;
	}
	
	
}

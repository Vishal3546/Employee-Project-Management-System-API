package com.project.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.employee.model.EmployeeModel;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, Integer> {
	
	List<EmployeeModel> findByDepartment(String d);
}

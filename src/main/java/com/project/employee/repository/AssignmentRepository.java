package com.project.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.employee.model.AssignmentModel;

public interface AssignmentRepository extends JpaRepository<AssignmentModel, Integer> {

	List<AssignmentModel> findByPrid(int id);
}

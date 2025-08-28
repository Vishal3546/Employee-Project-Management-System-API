package com.project.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.employee.model.ProjectModel;

public interface ProjectRepository extends JpaRepository<ProjectModel, Integer> {

}

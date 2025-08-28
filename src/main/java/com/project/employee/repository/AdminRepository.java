package com.project.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.employee.model.AdminModel;

public interface AdminRepository extends JpaRepository<AdminModel, Integer> {

	AdminModel findByEmailAndPassword(String email,String password);
}

package com.ai.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ai.model.Department;


@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer>{
	

	
}

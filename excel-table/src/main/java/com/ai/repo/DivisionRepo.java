package com.ai.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ai.model.Division;

@Repository
public interface DivisionRepo extends JpaRepository<Division, Integer>{
	
}

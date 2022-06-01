package com.ai.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ai.model.Project;

public interface ProjectRepo extends JpaRepository<Project, Integer> {

}

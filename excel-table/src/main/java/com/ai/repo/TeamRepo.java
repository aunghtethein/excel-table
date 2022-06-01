package com.ai.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ai.model.Team;

public interface TeamRepo extends JpaRepository<Team, Integer>{

}

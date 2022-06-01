package com.ai.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import com.ai.model.Staff;

public interface StaffRepo extends JpaRepository<Staff, Integer> {

}

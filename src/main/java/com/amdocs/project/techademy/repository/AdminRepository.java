package com.amdocs.project.techademy.repository;

import com.amdocs.project.techademy.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
}

package com.amdocs.project.techademy.repository;

import com.amdocs.project.techademy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}

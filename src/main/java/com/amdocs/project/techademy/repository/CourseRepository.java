package com.amdocs.project.techademy.repository;

import com.amdocs.project.techademy.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}

package com.amdocs.project.techademy.repository;

import com.amdocs.project.techademy.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
}

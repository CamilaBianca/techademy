package com.amdocs.project.techademy.repository;

import com.amdocs.project.techademy.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
}

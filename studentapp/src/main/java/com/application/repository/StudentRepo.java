package com.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.model.Student;

public interface StudentRepo extends JpaRepository<Student, String> {

}

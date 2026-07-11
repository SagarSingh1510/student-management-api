package com.sagar.student_management_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sagar.student_management_api.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    
}

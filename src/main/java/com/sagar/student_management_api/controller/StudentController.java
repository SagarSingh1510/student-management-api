package com.sagar.student_management_api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.sagar.student_management_api.model.Student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class StudentController {
    @GetMapping("/")
    public String home() {
        return "Welcome to Student Management API!";
    }
    @GetMapping("/about")
    public String about() {
        return "This project is built using Spring Boot";
    }
    @GetMapping("/hello")
    public String hello() {
        return "Hello Sagar!";
    }
    @GetMapping("/students")
        public List<Student> student(){
            List<Student> students=new ArrayList<>();
            Student s1=new Student(1, "Sagar", "singh@gmail.com");
            students.add(s1);
            Student s2=new Student(2, "Harsh", "singh1@gmail.com");
            students.add(s2);
            Student s3=new Student(3, "Pawan", "singh2@gmail.com");
            students.add(s3);
            return students;
        }
    
    
    
}

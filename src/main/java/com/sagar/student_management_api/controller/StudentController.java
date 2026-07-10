package com.sagar.student_management_api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.sagar.student_management_api.model.Student;
import com.sagar.student_management_api.services.StudentService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
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
        public List<Student> students(){
            return studentService.getStudents();
        }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }
    
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }
    
    
    
}

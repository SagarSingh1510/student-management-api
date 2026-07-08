package com.sagar.student_management_api.controller;

import org.springframework.web.bind.annotation.RestController;
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
    
    
}

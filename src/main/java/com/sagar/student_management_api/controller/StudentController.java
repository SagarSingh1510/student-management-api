package com.sagar.student_management_api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.sagar.student_management_api.dto.StudentResponseDTO;
import com.sagar.student_management_api.model.Student;
import com.sagar.student_management_api.services.StudentService;

import jakarta.validation.Valid;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    
    @GetMapping("/{id}")
    public StudentResponseDTO getStudentById(@PathVariable Integer id) {
        return studentService.getStudentById(id);
    }
    
    @PostMapping
    public StudentResponseDTO addStudent(@Valid @RequestBody Student student) {
        return studentService.addStudent(student);
    }
    
    @PutMapping("/{id}")
    public StudentResponseDTO updateStudent(@PathVariable Integer id,@Valid @RequestBody Student updatedStudent) {
        return studentService.updateStudent(id, updatedStudent);
    }
    

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Integer id){
        return studentService.deleteStudent(id);
    }
    
    @GetMapping
    public Page<StudentResponseDTO> getStudents(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "5") int size,@RequestParam(defaultValue="id") String sortField, @RequestParam(defaultValue = "asc") String direction,@RequestParam(required=false) String name){
        return studentService.getStudents(page, size,sortField,direction,name);
    }
    
}

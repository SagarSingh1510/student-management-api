package com.sagar.student_management_api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sagar.student_management_api.model.Student;
import com.sagar.student_management_api.repository.StudentRepository;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }
    
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentById(int id){
        return studentRepository.findById(id).orElse(null);
    }

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public Student updateStudent(int id,Student updatedStudent){
        updatedStudent.setId(id);
        return studentRepository.save(updatedStudent);
    }

    public String deleteStudent(int id){
        if(studentRepository.existsById(id)){
            studentRepository.deleteById(id);
            return "Deleted Sucessfully";
        }
        return "Student not found";
    }
}

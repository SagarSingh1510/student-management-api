package com.sagar.student_management_api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sagar.student_management_api.model.Student;

@Service
public class StudentService {
    private List<Student> students= new ArrayList<>();
    public StudentService(){
        students.add(new Student(1, "Sagar", "singh@gmail.com"));
        students.add(new Student(2, "Harsh", "singh1@gmail.com"));
        students.add(new Student(3, "Pawan", "singh2@gmail.com"));
    }
    public List<Student> getStudents(){
        return students;
    }

    public Student getStudentById(int id){
        for(Student student: students){
            if(student.getId()==id){
                return student;
            }
        }
        return null;
    }

    public Student addStudent(Student student){
        students.add(student);
        return students.getLast();
    }

    public Student updateStudent(int id,Student updatedStudent){
        for(Student student:students){
            if(student.getId()==id){
                student.setName(updatedStudent.getName());
                student.setEmail(updatedStudent.getEmail());
                return student;
            }
        }
        return null;
    }

    public String deleteStudent(int id){
        for(Student student:students){
            if(student.getId()==id){
                students.remove(student);
                return "Student deleted sucessfully";
            }
        }
        return "No student found";
    }
}

package com.sagar.student_management_api.services;


import com.sagar.student_management_api.dto.StudentResponseDTO;
import com.sagar.student_management_api.exception.GlobalExceptionHandler;
import com.sagar.student_management_api.mapper.StudentMapper;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sagar.student_management_api.model.Student;
import com.sagar.student_management_api.repository.StudentRepository;

@Service
public class StudentService {
    private final GlobalExceptionHandler globalExceptionHandler;
    private final StudentRepository studentRepository;
    private static final List<String> ALLOWED_FIELDS= List.of("id","name","email");
    public StudentService(StudentRepository studentRepository, GlobalExceptionHandler globalExceptionHandler){
        this.studentRepository=studentRepository;
        this.globalExceptionHandler = globalExceptionHandler;
    }
    
    public List<StudentResponseDTO> getStudents(){
        List<Student> students=studentRepository.findAll();
        return StudentMapper.toDTOList(students);
    }

    public StudentResponseDTO getStudentById(Integer id){
            Student student=studentRepository.findById(id).orElse(null);
            return StudentMapper.toDTO(student);
    }

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public StudentResponseDTO updateStudent(Integer id,Student updatedStudent){
        updatedStudent.setId(id);
        Student student=studentRepository.save(updatedStudent);
        return StudentMapper.toDTO(student);
    }

    public String deleteStudent(Integer id){
        if(studentRepository.existsById(id)){
            studentRepository.deleteById(id);
            return "Deleted Sucessfully";
        }
        return "Student not found";
    }

    public Page<Student> getStudents(int page,int size,String sortField, String direction, String name){
        if(!ALLOWED_FIELDS.contains(sortField)){
            return null;
        }
        
        Sort sort= direction.equalsIgnoreCase("desc")?Sort.by(sortField).descending():Sort.by(sortField).ascending();
        Pageable pageable = PageRequest.of(page,size,sort);

        if(name!= null && !name.isBlank())return studentRepository.findByName(name, pageable);
        return studentRepository.findAll(pageable);
    }

    
}

package com.sagar.student_management_api.services;


import com.sagar.student_management_api.dto.StudentResponseDTO;
import com.sagar.student_management_api.exception.GlobalExceptionHandler;
import com.sagar.student_management_api.exception.SortFieldNotFoundException;
import com.sagar.student_management_api.exception.StudentNotFoundException;
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
    private final StudentRepository studentRepository;
    private static final List<String> ALLOWED_FIELDS= List.of("id","name","email");
    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }
    
    public List<StudentResponseDTO> getStudents(){
        List<Student> students=studentRepository.findAll();
        return StudentMapper.toDTOList(students);
    }

    public StudentResponseDTO getStudentById(Integer id){
            Student student=studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException("Student with id "+id+" not found"));
            return StudentMapper.toDTO(student);
    }

    public StudentResponseDTO addStudent(Student student){
        Student std=studentRepository.save(student);
        return StudentMapper.toDTO(std);
    }

    public StudentResponseDTO updateStudent(Integer id,Student updatedStudent){
        if(!studentRepository.existsById(id)){
            throw new StudentNotFoundException("Student with ID "+ id+ " not found.");
        }
        updatedStudent.setId(id);
        Student student=studentRepository.save(updatedStudent);
        return StudentMapper.toDTO(student);
    }

    public String deleteStudent(Integer id){
        if(!studentRepository.existsById(id)){
            throw new StudentNotFoundException("Student with ID "+id+" not found.");
        }
        studentRepository.deleteById(id);
        return "Student with ID "+ id +" Deleted Sucessfully";
    }

    public Page<StudentResponseDTO> getStudents(int page,int size,String sortField, String direction, String name){
        if(!ALLOWED_FIELDS.contains(sortField)){
            throw new SortFieldNotFoundException("Invalid Sort Field: "+ sortField);
        }
        
        Sort sort= direction.equalsIgnoreCase("desc")?Sort.by(sortField).descending():Sort.by(sortField).ascending();
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<Student> students;
        if(name!= null && !name.isBlank())students=studentRepository.findByName(name, pageable);
        else students=studentRepository.findAll(pageable);
        
        return students.map(StudentMapper::toDTO);
    }

    
}

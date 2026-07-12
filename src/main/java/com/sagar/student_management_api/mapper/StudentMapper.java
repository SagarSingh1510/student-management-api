package com.sagar.student_management_api.mapper;

import java.util.ArrayList;
import java.util.List;

import com.sagar.student_management_api.dto.StudentResponseDTO;
import com.sagar.student_management_api.model.Student;

public class StudentMapper {
    public static StudentResponseDTO toDTO(Student student){
        if(student==null){
            return null;
        }
        return new StudentResponseDTO(student.getId(),student.getName(),student.getEmail());
    }
    public static List<StudentResponseDTO> toDTOList(List<Student> students) {

    List<StudentResponseDTO> dtoList = new ArrayList<>();

    for (Student student : students) {
        dtoList.add(toDTO(student));
    }

    return dtoList;
}
}

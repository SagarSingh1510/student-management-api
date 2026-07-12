package com.sagar.student_management_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Email(message = "Invalid Email format")
    @NotBlank(message="Email cannot be empty")
    private String email;
    public Student(){

    }
    public Student(Integer id, String name, String email){
        this.id=id;
        this.name=name;
        this.email=email;
    }
    public Integer getId() {
    return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Integer id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setEmail(String email){
        this.email=email;
    }
}

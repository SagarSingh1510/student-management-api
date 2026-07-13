package com.sagar.student_management_api.exception;

public class SortFieldNotFoundException extends RuntimeException{
    public SortFieldNotFoundException(String message){
        super(message);
    }
}

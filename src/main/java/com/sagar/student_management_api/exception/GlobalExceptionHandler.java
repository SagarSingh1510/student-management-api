package com.sagar.student_management_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidatioException(MethodArgumentNotValidException ex){
        String errorMessage=ex.getBindingResult()
                                .getFieldError()
                                .getDefaultMessage();

        return new ResponseEntity<>(errorMessage,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<String> handleStudentNotFoundException(StudentNotFoundException e){
        String errorMessage=e.getMessage();
        return new ResponseEntity<>(errorMessage,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SortFieldNotFoundException.class)
    public ResponseEntity<String> handleSortFieldNotFoundException(SortFieldNotFoundException e){
        String errorMessage=e.getMessage();
        return new ResponseEntity<>(errorMessage,HttpStatus.BAD_REQUEST);
    }
}

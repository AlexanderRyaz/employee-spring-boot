package com.example.employeespringboot.controller;

import com.example.employeespringboot.exeption.EmployeeDataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(EmployeeDataException.class)
    public ResponseEntity<String>handleEmployeeDataException(EmployeeDataException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}

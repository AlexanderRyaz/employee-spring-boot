package com.example.employeespringboot.controller;

import com.example.employeespringboot.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @GetMapping("/employees/{id}")
 public List<Employee> getEmployeesByDepartment(@PathVariable int id){

 }
}

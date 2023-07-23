package com.example.employeespringboot.controller;

import com.example.employeespringboot.exeption.EmployeeDataException;
import com.example.employeespringboot.model.Employee;
import com.example.employeespringboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) throws EmployeeDataException {
        Employee e = service.createEmployee(employee);
        return new ResponseEntity<>(e,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = service.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/salary/min")
    public ResponseEntity<Employee> getEmployeeWithMinSalary() {
        Employee employeeWithMinSalary = service.getEmployeeWithMinSalary();
        return new ResponseEntity<>(employeeWithMinSalary, HttpStatus.OK);
    }

    @GetMapping("/salary/max")
    public ResponseEntity<Employee> getEmployeeWithMaxSalary() {
        Employee employeeWithMaxSalary = service.getEmployeeWithMaxSalary();
        return new ResponseEntity<>(employeeWithMaxSalary, HttpStatus.OK);
    }

    @GetMapping("/high-salary")
    public ResponseEntity<List<Employee>> getEmployeesWithSalaryGreaterAverage(){
        List<Employee> employeesWithSalaryGreaterAverage = service.getEmployeesWithSalaryGreaterAverage();
        return new ResponseEntity<>(employeesWithSalaryGreaterAverage,HttpStatus.OK);
    }
    @GetMapping("salary/sum")
    public ResponseEntity<Integer>getSumSalary(){
        int sumSalary = service.getSumSalary();
        return new ResponseEntity<>(sumSalary,HttpStatus.OK);
    }
}

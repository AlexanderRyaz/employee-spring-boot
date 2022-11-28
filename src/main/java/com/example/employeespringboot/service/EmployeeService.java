package com.example.employeespringboot.service;

import com.example.employeespringboot.exeption.EmployeeDataException;
import com.example.employeespringboot.model.Employee;
import com.example.employeespringboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public void createEmployee(Employee employee) throws EmployeeDataException {
        employeeRepository.createEmployee(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    public int getSumSalary() {
        return employeeRepository.getSumSalary();
    }

    public Employee getEmployeeWithMinSalary() {
        return employeeRepository.getEmployeeWithMinSalary();
    }

    public Employee getEmployeeWithMaxSalary() {
        return employeeRepository.getEmployeeWithMaxSalary();
    }

    public List<Employee> getEmployeesWithSalaryGreaterAverage() {
        return employeeRepository.getEmployeesWithSalaryGreaterAverage();
    }

}

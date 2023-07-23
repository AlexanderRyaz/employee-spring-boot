package com.example.employeespringboot.service;

import com.example.employeespringboot.exeption.EmployeeDataException;
import com.example.employeespringboot.model.Employee;
import com.example.employeespringboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) throws EmployeeDataException {
        return employeeRepository.createEmployee(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    public int getSumSalary() {

        return getAllEmployees().stream().mapToInt(Employee::getSalary).sum();
    }

    public Employee getEmployeeWithMinSalary() {
        return getAllEmployees().stream().min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    public Employee getEmployeeWithMaxSalary() {
        return getAllEmployees().stream().max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    public List<Employee> getEmployeesWithSalaryGreaterAverage() {
        List<Employee> allEmployees = getAllEmployees();
        double averageSalary = allEmployees.stream().mapToDouble(Employee::getSalary).average().getAsDouble();
        return allEmployees.stream().filter(employee -> employee.getSalary() > averageSalary).toList();
    }


}

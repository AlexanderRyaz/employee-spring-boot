package com.example.employeespringboot.service;

import com.example.employeespringboot.model.Employee;
import com.example.employeespringboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

@Service
public class DepartmentService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployeeByDepartment(int id) {
        return employeeRepository.getAllEmployees().stream().filter(employee -> employee.getDepartment() == id).toList();
    }

    public int getSumSalaryByDepartment(int id) {
        return employeeRepository.getAllEmployees().stream().filter(employee -> employee.getDepartment() == id)
                .mapToInt(Employee::getSalary)
                .sum();
    }

    public int getMaxSalaryByDepartment(int id) {
        return employeeRepository.getAllEmployees().stream().filter(employee -> employee.getDepartment() == id)
                .mapToInt(Employee::getSalary).max()
                .orElse(0);
    }

    public int getMinSalaryByDepartment(int id) {
        return employeeRepository.getAllEmployees().stream().filter(employee -> employee.getDepartment() == id)
                .mapToInt(Employee::getSalary)
                .min()
                .orElse(0);
    }

    public Map<Integer, List<Employee>> groupEmployeeByDepartment() {
        return employeeRepository.getAllEmployees().stream().collect(groupingBy(Employee::getDepartment));
    }
}

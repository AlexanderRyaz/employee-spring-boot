package com.example.employeespringboot.service;

import com.example.employeespringboot.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    private static int counter = 1;

    private static final Map<Integer, Employee> employeeMap = new HashMap<>();

    public void createEmployee(Employee employee) {
        int id = counter++;
        employee.setId(id);
        employeeMap.put(id, employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeMap.values().stream().toList();
    }

    public int getSumSalary() {
        return employeeMap.values().stream().mapToInt(Employee::getSalary).sum();
    }

    public Employee getEmployeeWithMinSalary() {
        return employeeMap.values().stream().min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    public Employee getEmployeeWithMaxSalary() {
        return employeeMap.values().stream().max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    public List<Employee> getEmployeesWithSalaryGreaterAverage() {
        double averageSalary = employeeMap.values().stream().mapToInt(Employee::getSalary).average().getAsDouble();
        return employeeMap.values().stream().filter(employee -> employee.getSalary()>averageSalary).toList();
    }
}

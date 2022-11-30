package com.example.employeespringboot.service;

import com.example.employeespringboot.model.Employee;
import com.example.employeespringboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DepartmentService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployeesByDepartment(int id) {
        return employeeRepository.getEmployeeByDepartment(id);
    }

    public int getSumSalaryByDepartment(int id) {
        return employeeRepository.getSumSalaryByDepartment(id);
    }

    public int getSalaryMaxByDepartment(int id) {
        return employeeRepository.getMaxSalaryByDepartment(id);
    }

    public int getSalaryMinByDepartment(int id) {
        return employeeRepository.getMinSalaryByDepartment(id);
    }

    public Map<Integer, List<Employee>> getEmployeesGroupedByDepartment() {
        return employeeRepository.groupEmployeeByDepartment();
    }
}

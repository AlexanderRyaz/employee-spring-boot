package com.example.employeespringboot.repository;

import com.example.employeespringboot.exeption.EmployeeDataException;
import com.example.employeespringboot.model.Employee;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

@Component
public class EmployeeRepository {
    private static int counter = 1;

    private static final Map<Integer, Employee> employeeMap = new HashMap<>();

    public Employee createEmployee(Employee employee) throws EmployeeDataException {
        checkEmployee(employee);
        int id = counter++;
        employee.setId(id);
        employee.setFirstName(StringUtils.capitalize(employee.getFirstName()));
        employee.setLastName(StringUtils.capitalize(employee.getLastName()));
        employeeMap.put(id, employee);
        return employee;
    }

    public List<Employee> getAllEmployees() {
        return employeeMap.values().stream().toList();
    }




    private void checkEmployee(Employee employee) throws EmployeeDataException {
        boolean firstNameBlank = StringUtils.isBlank(employee.getFirstName());
        boolean lastNameBlank = StringUtils.isBlank(employee.getLastName());
        boolean firstNameAlphabetic = StringUtils.isAlpha(employee.getFirstName());
        boolean lastNameAlphabetic = StringUtils.isAlpha(employee.getLastName());
        if (firstNameBlank || lastNameBlank || !firstNameAlphabetic || !lastNameAlphabetic) {
            throw new EmployeeDataException("Неправильно введены данные пользователя");
        }
    }
}

package com.example.employeespringboot.repository;

import com.example.employeespringboot.model.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Stream;

class EmployeeRepositoryTest {
    @Autowired
    private EmployeeRepository repository;

    @ParameterizedTest
    @MethodSource("prepareData")
    void createEmployee() {
        Employee employee = new Employee();
        employee.setLastName("Иванов");
        employee.setFirstName("Саша");
        employee.setDepartment(1);
        employee.setSalary(17000);
        employee.setId(1);

        Employee employee1 = new Employee();
        employee1.setLastName("Иванов");
        employee1.setFirstName("саша");
        employee1.setDepartment(1);
        employee1.setSalary(17000);

    }

    @Test
    void getAllEmployees() {
    }

    private static Stream<Arguments> prepareData() {
        return
    }
}
package com.example.employeespringboot.service;

import com.example.employeespringboot.exeption.EmployeeDataException;
import com.example.employeespringboot.model.Employee;
import com.example.employeespringboot.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class EmployeeServiceTest {
    @MockBean
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeService employeeService;

    @Test
    void createEmployee() throws EmployeeDataException {
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

        when(employeeRepository.createEmployee(any())).thenReturn(employee);
        Employee e = employeeService.createEmployee(employee1);
        assertEquals("Иванов",e.getLastName());
        assertEquals("Cаша",e.getFirstName());
        assertEquals(1,e.getDepartment());
        assertEquals(17000,e.getSalary());
        assertEquals(1,e.getId());
    }

    @Test
    void getAllEmployees() {
    }

    @Test
    void getSumSalary() {

    }

    @Test
    void getEmployeeWithMinSalary() {
    }

    @Test
    void getEmployeeWithMaxSalary() {
    }

    @Test
    void getEmployeesWithSalaryGreaterAverage() {
    }
}
package com.example.employeespringboot.service;

import com.example.employeespringboot.ServiceTest;
import com.example.employeespringboot.exeption.EmployeeDataException;
import com.example.employeespringboot.model.Employee;
import com.example.employeespringboot.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest({EmployeeService.class, EmployeeRepository.class})
class EmployeeServiceTest extends ServiceTest {
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

        Employee employee1 = buildEmployee("саша", "Иванов", 1, 17000);

        when(employeeRepository.createEmployee(any())).thenReturn(employee);
        Employee e = employeeService.createEmployee(employee1);
        assertEquals("Иванов", e.getLastName());
        assertEquals("Саша", e.getFirstName());
        assertEquals(1, e.getDepartment());
        assertEquals(17000, e.getSalary());
        assertEquals(1, e.getId());
    }


    @Test
    void getAllEmployees() {
        when(employeeRepository.getAllEmployees()).thenReturn(getEmployeeList());
        List<Employee> actualEmployees = employeeService.getAllEmployees();
        assertNotNull(actualEmployees);
        assertEquals(6, actualEmployees.size());
        assertTrue(List.of("Petrov", "Ivanov", "Petrovin", "Trunov", "Reva", "Petrovichev").containsAll(actualEmployees
                .stream().map(Employee::getLastName).toList()));
    }

    @Test
    void getSumSalary() {
        when(employeeRepository.getAllEmployees()).thenReturn(getEmployeeList());
        int actualSumSalary = employeeService.getSumSalary();
        assertEquals(44000, actualSumSalary);
    }

    @Test
    void getEmployeeWithMinSalary() {
        when(employeeRepository.getAllEmployees()).thenReturn(getEmployeeList());
        Employee actualEmployeeWithMinSalary = employeeService.getEmployeeWithMinSalary();
        assertEquals("Grishan", actualEmployeeWithMinSalary.getFirstName());
        assertEquals(6, actualEmployeeWithMinSalary.getId());
    }

    @Test
    void getEmployeeWithMaxSalary() {
        when(employeeRepository.getAllEmployees()).thenReturn(getEmployeeList());
        Employee actualEmployeeWithMaxSalary = employeeService.getEmployeeWithMaxSalary();
        assertEquals("Dima", actualEmployeeWithMaxSalary.getFirstName());
        assertEquals(7, actualEmployeeWithMaxSalary.getId());
    }

    @Test
    void getEmployeesWithSalaryGreaterAverage() {
        when(employeeRepository.getAllEmployees()).thenReturn(getEmployeeList());
        List<Employee> actualEmployeesWithSalaryGreaterAverage = employeeService.getEmployeesWithSalaryGreaterAverage();
        assertEquals(3, actualEmployeesWithSalaryGreaterAverage.size());
        assertTrue(List.of("Petrov", "Petrovin", "Reva").containsAll(actualEmployeesWithSalaryGreaterAverage
                .stream().map(Employee::getLastName).toList()));
    }
}
package com.example.employeespringboot.service;

import com.example.employeespringboot.ServiceTest;
import com.example.employeespringboot.model.Employee;
import com.example.employeespringboot.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@WebMvcTest({DepartmentService.class, EmployeeRepository.class})
class DepartmentServiceTest extends ServiceTest {
    @MockBean
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentService service;

    @Test
    void getEmployeeByDepartment() {
        when(employeeRepository.getAllEmployees()).thenReturn(getEmployeeList());
        List<Employee> actualEmployeeByDepartment = service.getEmployeeByDepartment(2);
        assertEquals(3, actualEmployeeByDepartment.size());
        assertTrue(List.of("Petrov", "Petrovin", "Reva").containsAll(actualEmployeeByDepartment
                .stream().map(Employee::getLastName).toList()));
    }

    @Test
    void getSumSalaryByDepartment() {
        when(employeeRepository.getAllEmployees()).thenReturn(getEmployeeList());
        int actualSumSalaryByDepartment = service.getSumSalaryByDepartment(1);
        assertEquals(15000, actualSumSalaryByDepartment);
    }

    @Test
    void getMaxSalaryByDepartment() {
        when(employeeRepository.getAllEmployees()).thenReturn(getEmployeeList());
        int actualMaxSalaryByDepartment = service.getMaxSalaryByDepartment(2);
        assertEquals(11000,actualMaxSalaryByDepartment);
    }

    @Test
    void getMinSalaryByDepartment() {
        when(employeeRepository.getAllEmployees()).thenReturn(getEmployeeList());
        int actualMinSalaryByDepartment = service.getMinSalaryByDepartment(1);
        assertEquals(3000,actualMinSalaryByDepartment);
    }

    @Test
    void groupEmployeeByDepartment() {
        when(employeeRepository.getAllEmployees()).thenReturn(getEmployeeList());
        Map<Integer, List<Employee>> actualEmployeeByDepartment = service.groupEmployeeByDepartment();
        assertEquals(2,actualEmployeeByDepartment.size());
        assertTrue(List.of(1,2).containsAll(actualEmployeeByDepartment.keySet()));
        assertTrue(List.of(1,3,6).containsAll(actualEmployeeByDepartment.get(1).stream().map(Employee::getId).toList()));
        assertTrue(List.of(7,5,4).containsAll(actualEmployeeByDepartment.get(2).stream().map(Employee::getId).toList()));
    }
}
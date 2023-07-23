package com.example.employeespringboot.repository;

import com.example.employeespringboot.exeption.EmployeeDataException;
import com.example.employeespringboot.model.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(EmployeeRepository.class)
class EmployeeRepositoryTest {
    @Autowired
    private EmployeeRepository repository;

    @ParameterizedTest
    @MethodSource("prepareData")
    void createEmployee(Employee employee, String lastname, String firstName) throws EmployeeDataException {
        Employee actualEmployee = repository.createEmployee(employee);
        assertEquals(lastname, actualEmployee.getLastName());
        assertEquals(firstName, actualEmployee.getFirstName());
        assertNotEquals(0, actualEmployee.getId());
    }

    @ParameterizedTest
    @MethodSource("prepareDataErrorCase")
    void createEmployeeErrorCase(Employee employee, String errorMessage) {
        EmployeeDataException actualEmployeeDataException = assertThrows(EmployeeDataException
                .class, () -> repository.createEmployee(employee));
        assertEquals(errorMessage, actualEmployeeDataException.getMessage());
    }

    @Test
    void getAllEmployees() throws EmployeeDataException {
        repository.createEmployee(buildEmployee("Иванов", "Саша"));
        repository.createEmployee(buildEmployee("Петров", "Петя"));
        List<Employee> actualAllEmployees = repository.getAllEmployees();
        assertEquals(2, actualAllEmployees.size());
        assertTrue(List.of("Иванов", "Петров").containsAll(actualAllEmployees
                .stream().map(Employee::getLastName).toList()));
    }

    private static Stream<Arguments> prepareData() {
        return Stream.of(
                Arguments.of(buildEmployee("Иванов", "Саша"), "Иванов", "Саша"),
                Arguments.of(buildEmployee("иванов", "Саша"), "Иванов", "Саша"),
                Arguments.of(buildEmployee("Иванов", "саша"), "Иванов", "Саша")
        );
    }

    private static Stream<Arguments> prepareDataErrorCase() {
        return Stream.of(
                Arguments.of(buildEmployee("Ивано.в", "Саша"), "Неправильно введена фамилия пользователя"),
                Arguments.of(buildEmployee("Иванов", "Саш.а"), "Неправильно введено имя пользователя")
        );
    }

    private static Employee buildEmployee(String lastName, String firstname) {
        Employee employee = new Employee();
        employee.setLastName(lastName);
        employee.setFirstName(firstname);
        employee.setDepartment(1);
        employee.setSalary(17000);
        return employee;
    }
}
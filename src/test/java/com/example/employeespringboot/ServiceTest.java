package com.example.employeespringboot;

import com.example.employeespringboot.model.Employee;

import java.util.List;

public class ServiceTest {
    public List<Employee> getEmployeeList() {

        Employee employee1 = buildEmployee("Grisha", "Petrov", 2, 10000);
        employee1.setId(4);

        Employee employee2 = buildEmployee("Misha", "Ivanov", 1, 7000);
        employee2.setId(1);

        Employee employee3 = buildEmployee("Serega", "Petrovin", 2, 8000);
        employee3.setId(5);

        Employee employee4 = buildEmployee("Sasha", "Trunov", 1, 5000);
        employee4.setId(3);

        Employee employee5 = buildEmployee("Dima", "Reva", 2, 11000);
        employee5.setId(7);

        Employee employee6 = buildEmployee("Grishan", "Petrovichev", 1, 3000);
        employee6.setId(6);
        return List.of(employee1, employee2, employee3, employee4, employee5, employee6);
    }

    protected Employee buildEmployee(String firstName, String lastName, int department, int salary) {
        Employee employee1 = new Employee();
        employee1.setLastName(lastName);
        employee1.setFirstName(firstName);
        employee1.setDepartment(department);
        employee1.setSalary(salary);
        return employee1;
    }
}

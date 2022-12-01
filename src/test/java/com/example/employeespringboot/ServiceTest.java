package com.example.employeespringboot;

import com.example.employeespringboot.model.Employee;

import java.util.List;

public class ServiceTest {
    public List<Employee> getEmployeeList() {
        Employee employee1 = new Employee();
        employee1.setFirstName("Grisha");
        employee1.setLastName("Petrov");
        employee1.setDepartment(2);
        employee1.setSalary(10000);
        employee1.setId(4);

        Employee employee2 = new Employee();
        employee2.setFirstName("Misha");
        employee2.setLastName("Ivanov");
        employee2.setDepartment(1);
        employee2.setSalary(7000);
        employee2.setId(1);

        Employee employee3 = new Employee();
        employee3.setFirstName("Serega");
        employee3.setLastName("Petrovin");
        employee3.setDepartment(2);
        employee3.setSalary(8000);
        employee3.setId(5);

        Employee employee4 = new Employee();
        employee4.setFirstName("Sasha");
        employee4.setLastName("Trunov");
        employee4.setDepartment(1);
        employee4.setSalary(5000);
        employee4.setId(3);

        Employee employee5 = new Employee();
        employee5.setFirstName("Dima");
        employee5.setLastName("Reva");
        employee5.setDepartment(2);
        employee5.setSalary(11000);
        employee5.setId(7);

        Employee employee6 = new Employee();
        employee6.setFirstName("Grishan");
        employee6.setLastName("Petrovichev");
        employee6.setDepartment(1);
        employee6.setSalary(3000);
        employee6.setId(6);
        return List.of(employee1,employee2,employee3,employee4,employee5,employee6);
    }
}

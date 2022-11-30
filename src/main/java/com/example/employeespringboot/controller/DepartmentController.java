package com.example.employeespringboot.controller;

import com.example.employeespringboot.model.Employee;
import com.example.employeespringboot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @GetMapping("/employees/{id}")
 public List<Employee> getEmployeesByDepartment(@PathVariable int id){
return departmentService.getEmployeesByDepartment(id);
 }
 @GetMapping("{id}/salary/sum")
    public int getSumSalaryByDepartment(@PathVariable int id){
        return departmentService.getSumSalaryByDepartment(id);
 }
 @GetMapping("{id}/salary/max")
    public int getSalaryMaxByDepartment(@PathVariable int id){
        return departmentService.getSalaryMaxByDepartment(id);
 }
    @GetMapping("{id}/salary/min")
    public int getSalaryMinByDepartment(@PathVariable int id) {
        return departmentService.getSalaryMinByDepartment(id);
    }
    @GetMapping("department/employees")
    public Map<Integer,List<Employee>> getEmployeesGroupedByDepartment() {
        return departmentService.getEmployeesGroupedByDepartment();
    }
    }







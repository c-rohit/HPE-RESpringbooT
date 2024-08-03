package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeManager employeeManager;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeManager.getEmployees().getEmployeeList();
    }

    @PostMapping
    public void addEmployee(@RequestBody Employee newEmployee) {
        employeeManager.getEmployees().getEmployeeList().add(newEmployee);
    }
}

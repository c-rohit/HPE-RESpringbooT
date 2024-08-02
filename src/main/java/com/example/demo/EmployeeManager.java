package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    private Employees employees;

    public EmployeeManager() {
        employees = new Employees();
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "John", "Doe", "john.doe@example.com", "Developer"));
        employeeList.add(new Employee(2, "Jane", "Smith", "jane.smith@example.com", "Manager"));
        employeeList.add(new Employee(3, "Emily", "Johnson", "emily.johnson@example.com", "Designer"));
        employees.setEmployeeList(employeeList);
    }

    public Employees getEmployees() {
        return employees;
    }
}

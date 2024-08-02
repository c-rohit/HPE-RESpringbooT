package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Employees {
    private List<Employee> employeeList = new ArrayList<>();

    // Getter method
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    // Setter method
    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}

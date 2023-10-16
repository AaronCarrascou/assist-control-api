package com.example.Assistcontrolapi.service;

import com.example.Assistcontrolapi.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee createEmployee(Employee employee);

    void deleteEmployeeById(Long employeeId);
}

package com.crown.interactive.employee.attendance.register.services;

import com.crown.interactive.employee.attendance.register.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Optional<Employee> getEmployeeById(Long employeeId);

    Employee updateEmployee(Employee employee);

}

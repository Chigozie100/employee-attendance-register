package com.crown.interactive.employee.attendance.register.services;

import com.crown.interactive.employee.attendance.register.dtos.requests.EmployeeRequest;
import com.crown.interactive.employee.attendance.register.dtos.requests.UpdateEmployeeRequest;
import com.crown.interactive.employee.attendance.register.dtos.responses.EmployeeResponse;
import com.crown.interactive.employee.attendance.register.model.Employee;

import java.util.List;

public interface EmployeeService {
    void createEmployee(EmployeeRequest employeeRequest);

    List<EmployeeResponse> getAllEmployees();

    EmployeeResponse getEmployeeById(Long employeeId);

    void updateEmployee(Long employeeId, UpdateEmployeeRequest employeeRequest);

    List<EmployeeResponse> getEmployeesByDepartment(Long departmentId);
}

package com.crown.interactive.employee.attendance.register.services.serviceImpl;

import com.crown.interactive.employee.attendance.register.model.Employee;
import com.crown.interactive.employee.attendance.register.repositories.EmployeeRepository;
import com.crown.interactive.employee.attendance.register.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return List.of();
    }

    @Override
    public Optional<Employee> getEmployeeById(Long employeeId) {
        return Optional.empty();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return null;
    }
}

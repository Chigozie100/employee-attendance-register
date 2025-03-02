package com.crown.interactive.employee.attendance.register.repositories;

import com.crown.interactive.employee.attendance.register.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
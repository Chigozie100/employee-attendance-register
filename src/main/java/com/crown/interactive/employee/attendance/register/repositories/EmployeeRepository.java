package com.crown.interactive.employee.attendance.register.repositories;

import com.crown.interactive.employee.attendance.register.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByDepartments_Id(Long departmentId);
}
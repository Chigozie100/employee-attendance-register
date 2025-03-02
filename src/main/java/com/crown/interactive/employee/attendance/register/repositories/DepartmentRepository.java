package com.crown.interactive.employee.attendance.register.repositories;

import com.crown.interactive.employee.attendance.register.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
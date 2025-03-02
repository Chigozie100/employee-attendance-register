package com.crown.interactive.employee.attendance.register.repositories;

import com.crown.interactive.employee.attendance.register.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findByEmployeeIdAndSignInTimeBetween(Long employeeId, LocalDateTime start, LocalDateTime end);
}
package com.crown.interactive.employee.attendance.register.services;

import com.crown.interactive.employee.attendance.register.model.Attendance;

import java.time.LocalDateTime;
import java.util.List;

public interface AttendanceService {
    Attendance markAttendance(Attendance attendance);

    List<Attendance> getAttendanceByDateRange(Long employeeId, LocalDateTime start, LocalDateTime end);

}

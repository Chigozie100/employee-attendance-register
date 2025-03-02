package com.crown.interactive.employee.attendance.register.services;

import com.crown.interactive.employee.attendance.register.dtos.responses.AttendanceResponse;
import com.crown.interactive.employee.attendance.register.enums.AttendanceStatus;
import com.crown.interactive.employee.attendance.register.model.Attendance;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface AttendanceService {
    AttendanceResponse registerAttendance(Long employeeId, AttendanceStatus status);
    List<AttendanceResponse> getAttendanceByEmployeeAndDateRange(Long employeeId, LocalDate startDate, LocalDate endDate);
}

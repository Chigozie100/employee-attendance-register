package com.crown.interactive.employee.attendance.register.services;

import com.crown.interactive.employee.attendance.register.dtos.responses.AttendanceResponse;
import com.crown.interactive.employee.attendance.register.enums.AttendanceStatus;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceService {
    void registerAttendance(Long employeeId, AttendanceStatus status);
    List<AttendanceResponse> getAttendanceByEmployeeAndDateRange(Long employeeId, LocalDate startDate, LocalDate endDate);
}

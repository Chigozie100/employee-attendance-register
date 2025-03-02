package com.crown.interactive.employee.attendance.register.services.serviceImpl;

import com.crown.interactive.employee.attendance.register.model.Attendance;
import com.crown.interactive.employee.attendance.register.repositories.AttendanceRepository;
import com.crown.interactive.employee.attendance.register.services.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {
    private final AttendanceRepository attendanceRepository;

    @Override
    public Attendance markAttendance(Attendance attendance) {
        return null;
    }

    @Override
    public List<Attendance> getAttendanceByDateRange(Long employeeId, LocalDateTime start, LocalDateTime end) {
        return List.of();
    }
}

package com.crown.interactive.employee.attendance.register.services.serviceImpl;

import com.crown.interactive.employee.attendance.register.dtos.responses.AttendanceResponse;
import com.crown.interactive.employee.attendance.register.enums.AttendanceStatus;
import com.crown.interactive.employee.attendance.register.exception.CustomException;
import com.crown.interactive.employee.attendance.register.model.Attendance;
import com.crown.interactive.employee.attendance.register.model.Employee;
import com.crown.interactive.employee.attendance.register.repositories.AttendanceRepository;
import com.crown.interactive.employee.attendance.register.repositories.EmployeeRepository;
import com.crown.interactive.employee.attendance.register.services.AttendanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {
    private final AttendanceRepository attendanceRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public AttendanceResponse registerAttendance(Long employeeId, AttendanceStatus status) {
        log.info("Registering attendance for employee {}", employeeId);
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new CustomException(404, "Employee not found"));

        Attendance attendance = Attendance.builder()
                .employee(employee)
                .status(status)
                .signInTime(status == AttendanceStatus.SIGN_IN ? LocalDateTime.now() : null)
                .signOutTime(status == AttendanceStatus.SIGN_OUT ? LocalDateTime.now() : null)
                .build();

        Attendance attendance1 = attendanceRepository.save(attendance);
        log.info("Registered attendance for employee {}", employeeId);
        return getAttendanceResponse(attendance1);
    }

    @Override
    public List<AttendanceResponse> getAttendanceByEmployeeAndDateRange(Long employeeId, LocalDate startDate, LocalDate endDate) {
        log.info("Getting attendance for employee {}", employeeId);
        List<Attendance> attendance =attendanceRepository.findByEmployeeIdAndSignInTimeBetween(employeeId, startDate.atStartOfDay(), endDate.atTime(LocalTime.MAX));
        return attendance.stream().map(this::getAttendanceResponse).collect(Collectors.toList());
    }

    private AttendanceResponse getAttendanceResponse(Attendance attendance) {
        AttendanceResponse attendanceResponse = new AttendanceResponse();
        attendanceResponse.setSignInTime(attendance.getSignInTime());
        attendanceResponse.setSignOutTime(attendance.getSignOutTime());
        return attendanceResponse;
    }

}

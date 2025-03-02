package com.crown.interactive.employee.attendance.register.controllers;

import com.crown.interactive.employee.attendance.register.dtos.responses.AttendanceResponse;
import com.crown.interactive.employee.attendance.register.enums.AttendanceStatus;
import com.crown.interactive.employee.attendance.register.services.AttendanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;

    @PostMapping("/{employeeId}/{status}")
    public ResponseEntity<?> registerAttendance(
            @PathVariable Long employeeId, @PathVariable AttendanceStatus status) {
        log.info("Registering attendance for employee {} with status {}", employeeId, status);
        try {
            attendanceService.registerAttendance(employeeId, status);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid request");
        }
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<?> getAttendanceByEmployeeAndDateRange(
            @PathVariable Long employeeId,
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {
        log.info("get attendance for employee {} and startDate {}", employeeId, startDate);
        try{
            List<AttendanceResponse> attendance = attendanceService.getAttendanceByEmployeeAndDateRange(employeeId, startDate, endDate);
            return ResponseEntity.status(HttpStatus.OK).body(attendance);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}

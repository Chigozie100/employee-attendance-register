package com.crown.interactive.employee.attendance.register.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class AttendanceResponse {
    private LocalDateTime signInTime;
    private LocalDateTime signOutTime;
}

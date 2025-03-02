package com.crown.interactive.employee.attendance.register.model;

import com.crown.interactive.employee.attendance.register.enums.AttendanceStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private LocalDateTime signInTime;
    private LocalDateTime signOutTime;

    @Enumerated(EnumType.STRING)
    private AttendanceStatus status; // SIGN_IN, SIGN_OUT, SICK_LEAVE, ABSENCE
}

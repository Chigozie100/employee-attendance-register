package com.crown.interactive.employee.attendance.register.model;

import com.crown.interactive.employee.attendance.register.enums.EmployeeType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String address;

    @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}

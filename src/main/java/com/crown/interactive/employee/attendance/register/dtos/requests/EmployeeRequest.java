package com.crown.interactive.employee.attendance.register.dtos.requests;

import com.crown.interactive.employee.attendance.register.enums.EmployeeType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {
    private String firstName;
    private String lastName;
    private String gender;
    private String address;
    @NotNull(message = "department is required")
    private List<Long> departmentIds;
    @NotNull(message = "Employee type is required")
    private EmployeeType employeeType;
}

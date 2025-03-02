package com.crown.interactive.employee.attendance.register.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmployeeRequest {
    private String firstName;
    private String lastName;
    private String gender;
    private String address;
}

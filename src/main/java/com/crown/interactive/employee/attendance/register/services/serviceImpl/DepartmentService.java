package com.crown.interactive.employee.attendance.register.services.serviceImpl;

import com.crown.interactive.employee.attendance.register.dtos.requests.DepartmentRequest;
import com.crown.interactive.employee.attendance.register.dtos.responses.DepartmentResponse;

import java.util.List;

public interface DepartmentService {
    List<DepartmentResponse> getAllDepartments();
    void createDepartment(DepartmentRequest request);
}

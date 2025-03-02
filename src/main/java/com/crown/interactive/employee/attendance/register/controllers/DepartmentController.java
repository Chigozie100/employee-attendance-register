package com.crown.interactive.employee.attendance.register.controllers;

import com.crown.interactive.employee.attendance.register.dtos.responses.DepartmentResponse;
import com.crown.interactive.employee.attendance.register.model.Department;
import com.crown.interactive.employee.attendance.register.services.serviceImpl.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/departments")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<?> getAllDepartments() {
        log.info("Get all departments");
        List<DepartmentResponse> allDepartments = departmentService.getAllDepartments();
        try{
            return ResponseEntity.status(HttpStatus.OK).body(allDepartments);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}

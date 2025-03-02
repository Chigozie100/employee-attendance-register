package com.crown.interactive.employee.attendance.register.controllers;

import com.crown.interactive.employee.attendance.register.dtos.requests.EmployeeRequest;
import com.crown.interactive.employee.attendance.register.dtos.requests.UpdateEmployeeRequest;
import com.crown.interactive.employee.attendance.register.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeRequest employee) {
        log.info("Creating employee : {}", employee);
        try {
            employeeService.createEmployee(employee);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid request");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @RequestBody UpdateEmployeeRequest employee) {
        try {
            employeeService.updateEmployee(id, employee);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid request");
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllEmployees() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAllEmployees());
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/get-employee/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeeById(id));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/department/{departmentId}")
    public ResponseEntity<?> getEmployeesByDepartment(@PathVariable Long departmentId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeesByDepartment(departmentId));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}

package com.crown.interactive.employee.attendance.register.services.serviceImpl;

import com.crown.interactive.employee.attendance.register.dtos.responses.DepartmentResponse;
import com.crown.interactive.employee.attendance.register.model.Department;
import com.crown.interactive.employee.attendance.register.repositories.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Override
    public List<DepartmentResponse> getAllDepartments() {
        log.info("get all departments");
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map(this::getDepartmentResponse).collect(Collectors.toList());
    }

    private DepartmentResponse getDepartmentResponse(Department department) {
        DepartmentResponse departmentResponse = new DepartmentResponse();
        departmentResponse.setId(department.getId());
        departmentResponse.setName(department.getName());
        return departmentResponse;
    }
}

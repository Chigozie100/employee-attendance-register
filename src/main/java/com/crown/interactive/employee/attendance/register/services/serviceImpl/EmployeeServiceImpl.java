package com.crown.interactive.employee.attendance.register.services.serviceImpl;

import com.crown.interactive.employee.attendance.register.dtos.requests.EmployeeRequest;
import com.crown.interactive.employee.attendance.register.dtos.requests.UpdateEmployeeRequest;
import com.crown.interactive.employee.attendance.register.dtos.responses.EmployeeResponse;
import com.crown.interactive.employee.attendance.register.exception.CustomException;
import com.crown.interactive.employee.attendance.register.model.Department;
import com.crown.interactive.employee.attendance.register.model.Employee;
import com.crown.interactive.employee.attendance.register.repositories.DepartmentRepository;
import com.crown.interactive.employee.attendance.register.repositories.EmployeeRepository;
import com.crown.interactive.employee.attendance.register.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    public void createEmployee(EmployeeRequest employeeRequest) {
        log.info("Creating employee : {}", employeeRequest);
        List<Department> departments = departmentRepository.findAllById(employeeRequest.getDepartmentIds());
        if (departments.isEmpty()) {
            throw new CustomException(404, "Departments not found");
        }        Employee employee = mapToEmployee(employeeRequest);

        employee.setDepartments(departments);
        employeeRepository.save(employee);
        log.info("employee created : {}", employee);
    }

    @Override
    public List<EmployeeResponse> getAllEmployees() {
        log.info("Getting all employees");
       return employeeRepository.findAll().stream().map(this::mapToEmployeeResponse).collect(Collectors.toList());
    }

    @Override
    public EmployeeResponse getEmployeeById(Long employeeId) {
        log.info("Getting employee : {}", employeeId);
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new CustomException(404, "Employee not found"));
        return mapToEmployeeResponse(employee);
    }

    @Override
    public void updateEmployee(Long employeeId, UpdateEmployeeRequest employeeRequest) {
        log.info("Updating employee: {}", employeeId);

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new CustomException(404, "Employee id not found"));
        employee.setFirstName(employeeRequest.getFirstName());
        employee.setLastName(employeeRequest.getLastName());
        employee.setAddress(employeeRequest.getAddress());
        employee.setGender(employeeRequest.getGender());
        employeeRepository.save(employee);
    }

    @Override
    public List<EmployeeResponse> getEmployeesByDepartment(Long departmentId) {
        List<Employee> byDepartmentsId = employeeRepository.findByDepartments_Id(departmentId);
        return byDepartmentsId.stream().map(this::mapToEmployeeResponse).collect(Collectors.toList());
    }

    private Employee mapToEmployee(EmployeeRequest employeeRequest) {
        return Employee.builder()
                .firstName(employeeRequest.getFirstName())
                .lastName(employeeRequest.getLastName())
                .gender(employeeRequest.getGender())
                .address(employeeRequest.getAddress())
                .employeeType(employeeRequest.getEmployeeType())
                .build();
    }

    private EmployeeResponse mapToEmployeeResponse(Employee employee) {
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setFirstName(employee.getFirstName());
        employeeResponse.setLastName(employee.getLastName());
        employeeResponse.setGender(employee.getGender());
        employeeResponse.setAddress(employee.getAddress());
        return employeeResponse;
    }

}

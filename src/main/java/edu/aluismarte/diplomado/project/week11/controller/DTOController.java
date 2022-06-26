package edu.aluismarte.diplomado.project.week11.controller;

import edu.aluismarte.diplomado.project.week11.request.CreateEmployeeRequest;
import edu.aluismarte.diplomado.project.week11.response.CreateEmployeeResponse;
import edu.aluismarte.diplomado.project.week11.response.GetEmployeesResponse;
import edu.aluismarte.diplomado.project.week11.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author aluis on 6/26/2022.
 */
@Validated
@RestController
@RequiredArgsConstructor
public class DTOController {

    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<GetEmployeesResponse> getEmployees() {
        return ResponseEntity.ok(GetEmployeesResponse.builder().employees(employeeService.getEmployees()).build());
    }

    @PostMapping
    public ResponseEntity<CreateEmployeeResponse> createEmployee(@Valid CreateEmployeeRequest createEmployeeRequest) {
        return ResponseEntity.ok(CreateEmployeeResponse.builder()
                .employee(employeeService.createEmployee(createEmployeeRequest))
                .build());
    }
}

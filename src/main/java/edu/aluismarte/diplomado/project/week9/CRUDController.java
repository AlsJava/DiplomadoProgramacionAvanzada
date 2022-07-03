package edu.aluismarte.diplomado.project.week9;

import edu.aluismarte.diplomado.project.week9.network.request.CreateEmployeeRequest;
import edu.aluismarte.diplomado.project.week9.network.request.DeleteEmployeeRequest;
import edu.aluismarte.diplomado.project.week9.network.request.UpdateEmployeeRequest;
import edu.aluismarte.diplomado.project.week9.network.response.CreateEmployeeResponse;
import edu.aluismarte.diplomado.project.week9.network.response.DeleteEmployeeResponse;
import edu.aluismarte.diplomado.project.week9.network.response.GetEmployeesResponse;
import edu.aluismarte.diplomado.project.week9.network.response.UpdateEmployeeResponse;
import edu.aluismarte.diplomado.project.week9.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Los elementos básicos deben tener lo que llamamos un CRUD
 * <p>
 * CRUD: Create, Retrieve, Update, Delete
 * <p>
 * Por lo general los elementos expuestos en una API tienen un CRUD en cierta medida
 *
 * @author aluis on 7/3/2022.
 */
@RestController
@RequiredArgsConstructor
public class CRUDController {

    private final EmployeeService employeeService;

    /**
     * Representa la R del acrónimo de CRUD
     */
    @GetMapping("/CRUD")
    public ResponseEntity<GetEmployeesResponse> getEmployees() {
        return ResponseEntity.ok(GetEmployeesResponse.builder()
                .employees(employeeService.getEmployees())
                .build());
    }

    /**
     * Representa la C del acrónimo de CRUD
     */
    @PostMapping("/CRUD")
    public ResponseEntity<CreateEmployeeResponse> createEmployee(@RequestBody CreateEmployeeRequest createEmployeeRequest) {
        return ResponseEntity.ok(CreateEmployeeResponse.builder()
                .employee(employeeService.createEmployee(createEmployeeRequest))
                .build());
    }

    /**
     * Representa la U del acrónimo de CRUD
     */
    @PutMapping("/CRUD")
    public ResponseEntity<UpdateEmployeeResponse> updateEmployee(@RequestBody UpdateEmployeeRequest updateEmployeeRequest) {
        return ResponseEntity.ok(UpdateEmployeeResponse.builder()
                .employee(employeeService.updateEmployee(updateEmployeeRequest))
                .build());
    }

    /**
     * Representa la D del acrónimo de CRUD
     */
    @DeleteMapping("/CRUD")
    public ResponseEntity<DeleteEmployeeResponse> deleteEmployee(@RequestBody DeleteEmployeeRequest deleteEmployeeRequest) {
        employeeService.delete(deleteEmployeeRequest);
        return ResponseEntity.ok(DeleteEmployeeResponse.builder().build());
    }
}

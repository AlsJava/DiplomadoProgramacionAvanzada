package edu.aluismarte.diplomado.project.week9.controller;

import edu.aluismarte.diplomado.project.week9.network.request.CreateEmployeeRequest;
import edu.aluismarte.diplomado.project.week9.network.response.CreateEmployeeResponse;
import edu.aluismarte.diplomado.project.week9.network.response.GetEmployeesResponse;
import edu.aluismarte.diplomado.project.week9.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Una correcta implementación de un Rest Controller tiene las siguientes partes:
 *  - Un controller (Llama al servicio y construye los RESPONSE, no tiene ninguna lógica de negocio)
 *  - Una capa de Servicio (Toda la lógica y conexiones a DB debe estar escrita en esta clase)
 *  - Todos los llamados a la API usan objetos REQUEST en clases POJO para manejar los parámetros enviados
 *  - Todos los llamados a la API usan objetos RESPONSE en clases POJO para exponer la data al usuario
 *
 * @author aluis on 6/26/2022.
 */
@RestController
@RequiredArgsConstructor
public class DTOController {

    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<GetEmployeesResponse> getEmployees() {
        return ResponseEntity.ok(GetEmployeesResponse.builder()
                        .employees(employeeService.getEmployees())
                        .build());
    }

    @PostMapping
    public ResponseEntity<CreateEmployeeResponse> createEmployee(@RequestBody CreateEmployeeRequest createEmployeeRequest) {
        return ResponseEntity.ok(CreateEmployeeResponse.builder()
                .employee(employeeService.createEmployee(createEmployeeRequest))
                .build());
    }
}

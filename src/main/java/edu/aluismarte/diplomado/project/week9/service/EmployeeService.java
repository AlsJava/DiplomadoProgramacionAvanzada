package edu.aluismarte.diplomado.project.week9.service;

import edu.aluismarte.diplomado.project.domain.Employee;
import edu.aluismarte.diplomado.project.repositories.EmployeeRepository;
import edu.aluismarte.diplomado.project.week9.FactoryPattern;
import edu.aluismarte.diplomado.project.week9.network.dto.EmployeeDTO;
import edu.aluismarte.diplomado.project.week9.network.request.CreateEmployeeRequest;
import edu.aluismarte.diplomado.project.week9.network.request.DeleteEmployeeRequest;
import edu.aluismarte.diplomado.project.week9.network.request.UpdateEmployeeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author aluis on 6/26/2022.
 */
@RequiredArgsConstructor
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<EmployeeDTO> getEmployees() {
        return employeeRepository.findAll().stream().map(FactoryPattern.EmployeeDTOFactory::toEmployeeDTO).collect(Collectors.toList());
    }

    public EmployeeDTO createEmployee(CreateEmployeeRequest createEmployeeRequest) {
        Employee employee = FactoryPattern.EmployeeFactory.toEmployee(createEmployeeRequest);
        employeeRepository.save(employee);
        return employee.toDTO();
    }

    public EmployeeDTO updateEmployee(UpdateEmployeeRequest updateEmployeeRequest) {
        Employee employee = employeeRepository.findById(updateEmployeeRequest.getId()).orElseThrow();
        employee.applyChanges(updateEmployeeRequest);
        employeeRepository.save(employee);
        return employee.toDTO();
    }

    public void delete(DeleteEmployeeRequest deleteEmployeeRequest) {
        employeeRepository.deleteById(deleteEmployeeRequest.getId());
    }

}

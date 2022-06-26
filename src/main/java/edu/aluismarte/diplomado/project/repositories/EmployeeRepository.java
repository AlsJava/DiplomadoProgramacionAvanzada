package edu.aluismarte.diplomado.project.repositories;

import edu.aluismarte.diplomado.project.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author aluis on 6/12/2022.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

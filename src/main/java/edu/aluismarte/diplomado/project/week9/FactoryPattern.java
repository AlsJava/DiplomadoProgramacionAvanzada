package edu.aluismarte.diplomado.project.week9;

import edu.aluismarte.diplomado.project.domain.Employee;
import edu.aluismarte.diplomado.project.week9.network.dto.EmployeeDTO;
import edu.aluismarte.diplomado.project.week9.network.request.CreateEmployeeRequest;

/**
 * Mostrar el uso del Factory pattern en las conversiones de los objetos básicos cuando se transforman de un tipo a otro.
 * <p>
 * El ejemplo es usado en un servicio para evitar que la data de la DB que no debe exponerse llegue al cliente
 *
 * @author aluis on 6/4/2022.
 */
public class FactoryPattern {

    public static class EmployeeDTOFactory {

        /**
         * Patrón más separado, para hacer las conversiones
         * <p>
         * Aunque tiene ventajas, hace más difícil rastrear problemas relacionados con la conversión.
         * <p>
         * Cada clase debe tener su propia implementación, por lo que tendría 2 clases y esto lo hace más molesto y complejo
         *
         * @param employee El empleado a transformar
         * @return La versión DTO del Employee
         */
        public static EmployeeDTO toEmployeeDTO(Employee employee) {
            return EmployeeDTO.builder()
                    .id(employee.getId())
                    .name(employee.getName())
                    .build();
        }

    }

    public static class EmployeeFactory {

        public static Employee toEmployee(CreateEmployeeRequest createEmployeeRequest) {
            return Employee.builder()
                    .name(createEmployeeRequest.getName())
                    .description(createEmployeeRequest.getDescription())
                    .entryDate(createEmployeeRequest.getEntryDate())
                    .build();
        }
    }
}

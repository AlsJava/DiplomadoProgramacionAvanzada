package edu.aluismarte.diplomado.project.week9.network.dto;

import edu.aluismarte.diplomado.model.project.EmployeeStateJson2;
import edu.aluismarte.diplomado.model.project.EmployeeStateJson3;
import edu.aluismarte.diplomado.model.project.EmployeeStateJson;
import lombok.*;

/**
 * @author aluis on 6/26/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class EmployeeDTO {

    private Long id;
    private String name;
    /**
     * Ejemplo de ENUM normal, sin ningún convertidor
     */
    private EmployeeStateJson state1;
    /**
     * Ejemplo de un enum en con property
     */
    private EmployeeStateJson2 state2;
    /**
     * Ejemplo de un enum con @JsonValue
     */
    private EmployeeStateJson3 state3;
}

package edu.aluismarte.diplomado.project.week11.dto;

import edu.aluismarte.diplomado.model.project.EmployeeStateJson;
import edu.aluismarte.diplomado.model.project.EmployeeStateJson2;
import lombok.*;

/**
 * @author aluis on 6/26/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class EmployeeDTO {

    private Long id;
    private String name;

    /**
     * Ejemplo de un enum en con property
     */
    private EmployeeStateJson state1;

    /**
     * Ejemplo de un enum con @JsonValue
     */
    private EmployeeStateJson2 state2;
}

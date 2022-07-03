package edu.aluismarte.diplomado.project.week9.network.response;

import edu.aluismarte.diplomado.project.week9.network.dto.EmployeeDTO;
import lombok.*;

/**
 * @author aluis on 6/26/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UpdateEmployeeResponse {

    private EmployeeDTO employee;
}

package edu.aluismarte.diplomado.project.week11.response;

import edu.aluismarte.diplomado.project.week11.dto.EmployeeDTO;
import lombok.*;

import java.util.List;

/**
 * @author aluis on 6/26/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class GetEmployeesResponse {

    private List<EmployeeDTO> employees;
}

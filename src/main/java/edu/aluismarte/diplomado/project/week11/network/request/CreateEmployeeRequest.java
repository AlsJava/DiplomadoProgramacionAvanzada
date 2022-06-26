package edu.aluismarte.diplomado.project.week11.network.request;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * @author aluis on 6/26/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CreateEmployeeRequest {

    @NotEmpty
    private String name;
    private String description;
    @NotNull
    private LocalDate entryDate;
}

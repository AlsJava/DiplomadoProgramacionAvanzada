package edu.aluismarte.diplomado.project.week11.network.request;

import lombok.*;

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

    private String name;
    private String description;
    private LocalDate entryDate;
}

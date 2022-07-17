package edu.aluismarte.diplomado.project.week11.model;

import lombok.*;

import java.time.LocalDate;

/**
 * @author aluis on 7/17/2022.
 */

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ExerciseResponse {

    private LocalDate returnDate;
}

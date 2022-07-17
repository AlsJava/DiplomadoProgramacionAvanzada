package edu.aluismarte.diplomado.project.week11.command;

import edu.aluismarte.diplomado.project.week10.command.Command;
import edu.aluismarte.diplomado.project.week11.model.ExerciseResponse;
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
public class ExerciseCommand extends Command<ExerciseResponse> {

    private LocalDate localDate;
    private int vacationDays;
    private boolean explote;
}

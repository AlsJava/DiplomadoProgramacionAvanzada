package edu.aluismarte.diplomado.project.week11.service;

import edu.aluismarte.diplomado.project.week10.command.CommandBus;
import edu.aluismarte.diplomado.project.week11.command.ExerciseCommand;
import edu.aluismarte.diplomado.project.week11.model.ExerciseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * @author aluis on 7/17/2022.
 */
@RequiredArgsConstructor
@Service
public class Week11Service {

    private final CommandBus commandBus;

    public ExerciseResponse exercise(boolean explote, int vacationDays, LocalDate localDate) {
        return commandBus.sendCommand(ExerciseCommand.builder()
                .explote(explote)
                .vacationDays(vacationDays)
                .localDate(localDate)
                .build());
    }
}

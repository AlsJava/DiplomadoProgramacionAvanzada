package edu.aluismarte.diplomado.project.week11.command;

import edu.aluismarte.diplomado.project.week10.command.CommandEvent;
import edu.aluismarte.diplomado.project.week10.command.CommandHandler;
import edu.aluismarte.diplomado.project.week11.model.ExerciseResponse;
import edu.aluismarte.diplomado.project.week11.saga.SagaFactory;
import edu.aluismarte.diplomado.project.week11.saga.SagaOrchestrator;
import edu.aluismarte.diplomado.project.week11.saga.model.Saga;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author aluis on 7/17/2022.
 */
@Component
@RequiredArgsConstructor
@CommandEvent(command = ExerciseCommand.class)
public class ExerciseCommandHandler implements CommandHandler<ExerciseResponse, ExerciseCommand> {

    private final SagaOrchestrator sagaOrchestrator;

    @Value("${pattern.saga.timeout}")
    private int timeout;

    @Override
    public ExerciseResponse handle(ExerciseCommand command) {
        Saga<ExerciseResponse> saga = SagaFactory.createExerciseSaga(UUID.randomUUID(), command);
        return sagaOrchestrator.orchestrate(saga, timeout);
    }
}

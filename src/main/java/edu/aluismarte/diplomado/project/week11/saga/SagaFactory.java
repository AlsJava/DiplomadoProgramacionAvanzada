package edu.aluismarte.diplomado.project.week11.saga;

import edu.aluismarte.diplomado.model.project.Demo;
import edu.aluismarte.diplomado.model.project.DemoResponse;
import edu.aluismarte.diplomado.project.week11.command.ExerciseCommand;
import edu.aluismarte.diplomado.project.week11.model.ExerciseResponse;
import edu.aluismarte.diplomado.project.week11.model.SagaDemoStep1;
import edu.aluismarte.diplomado.project.week11.model.SagaDemoStep2;
import edu.aluismarte.diplomado.project.week11.saga.model.Saga;
import edu.aluismarte.diplomado.project.week11.saga.model.SagaPayLoadKey;
import edu.aluismarte.diplomado.project.week11.saga.model.SagaPayload;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SagaFactory {

    public static Saga<DemoResponse> createDemoSaga(UUID key, Demo demo) {
        SagaPayload<DemoResponse> sagaPayload = new SagaPayload<>();
        sagaPayload.addProperty(new SagaPayLoadKey<>("MyId", Demo.class), demo);
        return Saga.<DemoResponse>builder()
                .name("Hola")
                .key(key)
                .payload(sagaPayload)
                .requiredStep(List.of(
                        SagaDemoStep1.class,
                        SagaDemoStep2.class
                ))
                .build();
    }

    public static Saga<ExerciseResponse> createExerciseSaga(UUID key, ExerciseCommand exerciseCommand) {
        SagaPayload<ExerciseResponse> sagaPayload = new SagaPayload<>();
        sagaPayload.addProperty(new SagaPayLoadKey<>("command", ExerciseCommand.class), exerciseCommand);
        return Saga.<ExerciseResponse>builder()
                .name("Hola")
                .key(key)
                .payload(sagaPayload)
                .requiredStep(List.of(
                        // TODO implement the steps/
//                        SagaDemoStep1.class,
//                        SagaDemoStep2.class
                ))
                .build();
    }
}

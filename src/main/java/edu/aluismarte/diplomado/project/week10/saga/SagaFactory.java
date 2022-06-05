package edu.aluismarte.diplomado.project.week10.saga;

import edu.aluismarte.diplomado.model.project.Demo;
import edu.aluismarte.diplomado.model.project.DemoResponse;
import edu.aluismarte.diplomado.project.week10.model.SagaDemoStep1;
import edu.aluismarte.diplomado.project.week10.model.SagaDemoStep2;
import edu.aluismarte.diplomado.project.week10.saga.model.Saga;
import edu.aluismarte.diplomado.project.week10.saga.model.SagaPayLoadKey;
import edu.aluismarte.diplomado.project.week10.saga.model.SagaPayload;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SagaFactory {

    public static Saga<DemoResponse> createDemoSaga(String key, Demo demo) {
        SagaPayload<DemoResponse> sagaPayload = new SagaPayload<>();
        sagaPayload.addProperty(new SagaPayLoadKey<>("MyId", Demo.class), demo);
        return Saga.<DemoResponse>builder()
                .name("Hola")
                .key("My Key")
                .payload(sagaPayload)
                .requiredStep(List.of(
                        SagaDemoStep1.class,
                        SagaDemoStep2.class
                ))
                .build();
    }
}

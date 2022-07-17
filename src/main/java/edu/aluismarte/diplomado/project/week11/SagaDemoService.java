package edu.aluismarte.diplomado.project.week11;

import edu.aluismarte.diplomado.model.project.Demo;
import edu.aluismarte.diplomado.model.project.DemoResponse;
import edu.aluismarte.diplomado.project.week11.saga.SagaFactory;
import edu.aluismarte.diplomado.project.week11.saga.SagaOrchestrator;
import edu.aluismarte.diplomado.project.week11.saga.model.Saga;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author aluis on 6/4/2022.
 */
@Service
@RequiredArgsConstructor
public class SagaDemoService {

    private static final int TIMEOUT = 60;

    private final SagaOrchestrator sagaOrchestrator;

    public String runDemo() {
        Demo demo = Demo.builder().id(UUID.randomUUID().toString()).build();
        Saga<DemoResponse> saga = SagaFactory.createDemoSaga(UUID.randomUUID(), demo);
        DemoResponse demoResponse = sagaOrchestrator.orchestrate(saga, TIMEOUT);
        return demoResponse.getResult();
    }
}

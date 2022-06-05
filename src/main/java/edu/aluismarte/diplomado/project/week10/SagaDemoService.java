package edu.aluismarte.diplomado.project.week10;

import edu.aluismarte.diplomado.model.project.Demo;
import edu.aluismarte.diplomado.model.project.DemoResponse;
import edu.aluismarte.diplomado.project.week10.saga.SagaFactory;
import edu.aluismarte.diplomado.project.week10.saga.SagaOrchestrator;
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
        DemoResponse demoResponse = sagaOrchestrator.orchestrate(SagaFactory.createDemoSaga(UUID.randomUUID().toString(), demo), TIMEOUT);
        return demoResponse.getResult();
    }
}

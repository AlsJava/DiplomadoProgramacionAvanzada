package edu.aluismarte.diplomado.project.week10.model;

import edu.aluismarte.diplomado.model.project.Demo;
import edu.aluismarte.diplomado.model.project.DemoResponse;
import edu.aluismarte.diplomado.project.week10.saga.SagaOrchestrator;
import edu.aluismarte.diplomado.project.week10.saga.model.Saga;
import edu.aluismarte.diplomado.project.week10.saga.SagaFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SagaDemo {

    private final SagaOrchestrator sagaOrchestrator;

    private final int timeout = 20;

    public void callSaga() {
        Saga<DemoResponse> saga = SagaFactory.createDemoSaga("RandomID to identify saga", new Demo());
        sagaOrchestrator.orchestrate(saga, timeout);
    }
}

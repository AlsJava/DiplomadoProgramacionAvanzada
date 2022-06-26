package edu.aluismarte.diplomado.project.week11.model;

import edu.aluismarte.diplomado.model.project.DemoResponse;
import edu.aluismarte.diplomado.project.week11.saga.model.SagaStep;
import edu.aluismarte.diplomado.project.week11.saga.model.SagaStepCompensator;
import edu.aluismarte.diplomado.project.week11.saga.model.SagaStepHandler;
import org.springframework.stereotype.Component;

@Component
public class SagaDemoStep2 implements SagaStep<DemoResponse> {

    @Override
    public String getName() {
        return "Saga Step 2";
    }

    @Override
    public SagaStepHandler<DemoResponse> getHandler() {
        return sagaPayload -> {
            // Create object or something
            System.out.println("Running Handler Step 2");
            DemoResponse result = sagaPayload.getResult();
            result.setResult("OK");
            sagaPayload.setResult(result);
        };
    }

    @Override
    public SagaStepCompensator<DemoResponse> getCompensator() {
        return sagaPayload -> {
            // delete objects created
            System.out.println("Running Compensator Step 2");
        };
    }
}

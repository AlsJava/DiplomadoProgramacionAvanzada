package edu.aluismarte.diplomado.project.week11.saga.model;

public interface SagaStepHandler<T> {

    void handle(SagaPayload<T> sagaPayload);
}

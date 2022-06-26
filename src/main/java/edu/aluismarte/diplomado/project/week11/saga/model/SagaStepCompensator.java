package edu.aluismarte.diplomado.project.week11.saga.model;

public interface SagaStepCompensator<T> {

    void handle(SagaPayload<T> sagaPayload);
}

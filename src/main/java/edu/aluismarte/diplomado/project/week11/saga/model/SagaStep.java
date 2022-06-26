package edu.aluismarte.diplomado.project.week11.saga.model;

public interface SagaStep<T> {

    String getName();

    SagaStepHandler<T> getHandler();

    SagaStepCompensator<T> getCompensator();
}

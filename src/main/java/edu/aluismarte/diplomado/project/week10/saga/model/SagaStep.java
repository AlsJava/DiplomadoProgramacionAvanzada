package edu.aluismarte.diplomado.project.week10.saga.model;

public interface SagaStep<T> {

    String getName();

    SagaStepHandler<T> getHandler();

    SagaStepCompensator<T> getCompensator();
}

package edu.aluismarte.diplomado.project.week10.saga.model;

import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Saga<T> {

    private String name;
    private String key;

    private List<Class<? extends SagaStep<T>>> requiredStep;

    private SagaPayload<T> payload;

    @Setter
    private boolean isErrorOccurred;

    private boolean isCompleteExecution;

    @Setter
    private Class<? extends SagaStep<T>> currentStep;

    public void setIsCompleteExecution(boolean value) {
        if (value) {
            clearCurrentStep();
        }
        this.isCompleteExecution = value;
    }

    public void clearCurrentStep() {
        this.currentStep = null;
    }

}

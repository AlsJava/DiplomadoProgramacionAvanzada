package edu.aluismarte.diplomado.project.week11.saga.model;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Saga<T> {

    private String name;
    private UUID key;

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

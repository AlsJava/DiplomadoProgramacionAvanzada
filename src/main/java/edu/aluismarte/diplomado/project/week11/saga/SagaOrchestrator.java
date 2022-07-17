package edu.aluismarte.diplomado.project.week11.saga;

import edu.aluismarte.diplomado.project.week11.saga.model.Saga;
import edu.aluismarte.diplomado.project.week11.saga.model.SagaException;
import edu.aluismarte.diplomado.project.week11.saga.model.SagaStep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

@Slf4j
@Component
public class SagaOrchestrator {

    private final ApplicationContext applicationContext;

    public SagaOrchestrator(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public <T> T orchestrate(Saga<T> saga, int secondTimeout) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<T> future = executorService.submit(() -> orchestrate(saga));
        try {
            return future.get(secondTimeout, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            throw new SagaException(ex);
        } catch (TimeoutException | ExecutionException ex) {
            future.cancel(true);
            throw new SagaException(ex);
        }
    }

    private <T> T orchestrate(Saga<T> saga) {
        for (Class<? extends SagaStep<T>> sagaStep : saga.getRequiredStep()) {
            if (Thread.interrupted()) {
                triggerCompensation(saga);
            }
            saga.setCurrentStep(sagaStep);
            try {
                SagaStep<T> bean = applicationContext.getBean(sagaStep);
                log.info("Executing step for SAGA {} : {}", saga.getName(), bean.getName());
                bean.getHandler().handle(saga.getPayload());
            } catch (Exception ex) {
                triggerCompensation(saga);
                saga.setIsCompleteExecution(true);
                throw ex;
            }
        }
        saga.setIsCompleteExecution(true);
        return saga.getPayload().getResult();
    }

    private <T> void triggerCompensation(Saga<T> saga) {
        log.info("Triggering compensation SAGA {} : {}", saga.getName(), saga.getKey());
        int index = saga.getRequiredStep().indexOf(saga.getCurrentStep());
        for (int i = index; i >= 0; i--) {
            Class<? extends SagaStep<T>> sagaStep = saga.getRequiredStep().get(i);
            SagaStep<T> bean = applicationContext.getBean(sagaStep);
            if (bean.getCompensator() != null) {
                log.info("Triggering Compensation SAGA/Step: {}/{}", saga.getName(), bean.getName());
                bean.getCompensator().handle(saga.getPayload());
            } else {
                log.info("Step {}, no have Compensator", bean.getName());
            }
        }
    }
}

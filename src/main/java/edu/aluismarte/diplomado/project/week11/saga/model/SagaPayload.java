package edu.aluismarte.diplomado.project.week11.saga.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class SagaPayload<T> {

    @Getter
    @Setter
    private T result;

    private final Map<SagaPayLoadKey<?>, Object> properties = new HashMap<>();

    public <M> M getProperty(SagaPayLoadKey<M> sagaPayLoadKey) {
        return sagaPayLoadKey.getType().cast(properties.get(sagaPayLoadKey));
    }

    public <M> void addProperty(SagaPayLoadKey<M> sagaPayLoadKey, M value) {
        properties.put(sagaPayLoadKey, value);
    }

    public <M> boolean hasProperty(SagaPayLoadKey<M> sagaPayLoadKey) {
        return properties.containsKey(sagaPayLoadKey);
    }
}

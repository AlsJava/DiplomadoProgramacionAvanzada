package edu.aluismarte.diplomado.model.project;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Ejemplo de como se ve el objeto en JSON
 *
 * @author aluis on 6/26/2022.
 */
class EmployeeStateTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    private static final String RAW_JSON = "{\"state\":\"A1\"}";

    @Test
    void serializeEnumTest() throws JsonProcessingException {
        String jsonValue = objectMapper.writeValueAsString(DemoEnumComplete.builder().build());
        System.out.println("JSON:" + jsonValue);
        assertEquals(RAW_JSON, jsonValue);
    }

    @Test
    void deserializeEnumTest() throws IOException {
        DemoEnumComplete demoEnumComplete = objectMapper.readValue(RAW_JSON, DemoEnumComplete.class);
        System.out.println(demoEnumComplete);
        assertEquals(EmployeeState.FIRED, demoEnumComplete.getState());
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Getter
    @Setter
    @ToString
    static class DemoEnumComplete {

        @Builder.Default
        private EmployeeState state = EmployeeState.FIRED;
    }

}
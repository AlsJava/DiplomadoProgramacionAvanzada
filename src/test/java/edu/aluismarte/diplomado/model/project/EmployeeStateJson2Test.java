package edu.aluismarte.diplomado.model.project;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author aluis on 6/26/2022.
 */
class EmployeeStateJson2Test {

    private final ObjectMapper objectMapper = new ObjectMapper();

    private static final String RAW_JSON = "{\"state2\":3}";

    @Test
    void serializeEnumTest() throws JsonProcessingException {
        String jsonValue = objectMapper.writeValueAsString(DemoEnum.builder().build());
        System.out.println("JSON:" + jsonValue);
        assertEquals(RAW_JSON, jsonValue);
    }

    @Test
    void deserializeEnumTest() throws IOException {
        DemoEnum demoEnum = objectMapper.readValue(RAW_JSON, DemoEnum.class);
        System.out.println(demoEnum);
        assertEquals(EmployeeStateJson3.OUT, demoEnum.getState2());
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Getter
    @Setter
    @ToString
    static class DemoEnum {

        @Builder.Default
        private EmployeeStateJson3 state2 = EmployeeStateJson3.OUT;
    }

}
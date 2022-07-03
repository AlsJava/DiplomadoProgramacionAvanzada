package edu.aluismarte.diplomado.project.week9.network.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.aluismarte.diplomado.model.project.EmployeeStateJson;
import edu.aluismarte.diplomado.model.project.EmployeeStateJson2;
import edu.aluismarte.diplomado.model.project.EmployeeStateJson3;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author aluis on 6/26/2022.
 */
class EmployeeDTOTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    private static final String RAW_JSON = """
            {"id":1,"name":"Lala","state1":"OUT","state2":"0","state3":2}""";

    private final EmployeeDTO employeeDTOBase = EmployeeDTO.builder()
            .id(1L)
            .name("Lala")
            .state1(EmployeeStateJson.OUT)
            .state2(EmployeeStateJson2.ACTIVE)
            .state3(EmployeeStateJson3.PENSIONER)
            .build();

    @Test
    void serializeTest() throws JsonProcessingException {
        String jsonValue = objectMapper.writeValueAsString(employeeDTOBase);
        System.out.println(jsonValue);
        assertEquals(RAW_JSON, jsonValue);
    }

    @Test
    void deserializeTest() throws IOException {
        System.out.println("Raw JSON: " + RAW_JSON);
        EmployeeDTO employeeDTO = objectMapper.readValue(RAW_JSON, EmployeeDTO.class);
        System.out.println(employeeDTO);
        assertEquals(employeeDTOBase.getId(), employeeDTO.getId());
        assertEquals(employeeDTOBase.getName(), employeeDTO.getName());
        assertEquals(employeeDTOBase.getState1(), employeeDTO.getState1());
        assertEquals(employeeDTOBase.getState2(), employeeDTO.getState2());
        assertEquals(employeeDTOBase.getState3(), employeeDTO.getState3());
    }
}
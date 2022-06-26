package edu.aluismarte.diplomado.project.week11;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author aluis on 6/4/2022.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SagaControllerTest {

    @Autowired
    private SagaController sagaController;

    @Test
    void simpleRunTest() {
        ResponseEntity<String> response = sagaController.demo();
        assertEquals("OK", response.getBody());
    }

}
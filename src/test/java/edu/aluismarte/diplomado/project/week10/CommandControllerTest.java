package edu.aluismarte.diplomado.project.week10;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author aluis on 6/4/2022.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CommandControllerTest {

    @Autowired
    private CommandController commandController;

    @Test
    void simpleRunTest() {
        ResponseEntity<String> response = commandController.demo();
        assertEquals("OK", response.getBody());
    }

}
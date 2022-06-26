package edu.aluismarte.diplomado.project.week11;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author aluis on 6/4/2022.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SagaDemoServiceTest {

    @Autowired
    private SagaDemoService sagaDemoService;

    @Test
    void simpleRunTest() {
        assertEquals("OK", sagaDemoService.runDemo());
    }
}
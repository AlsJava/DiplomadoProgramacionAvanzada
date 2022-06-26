package edu.aluismarte.diplomado.project.week10;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author aluis on 6/4/2022.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CommandDemoServiceTest {

    @Autowired
    private CommandDemoService commandDemoService;

    @Test
    void simpleRunTest() {
        assertEquals("OK", commandDemoService.runDemo());
    }

}
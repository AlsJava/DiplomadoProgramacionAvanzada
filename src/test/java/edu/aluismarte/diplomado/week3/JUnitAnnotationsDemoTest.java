package edu.aluismarte.diplomado.week3;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Demostración general de uso de las annotation más comunes en JUnit cuando se trabaja
 * <p>
 * Created by Aluis on 10/18/2021.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JUnitAnnotationsDemoTest {

    public static final String PRODUCTION_TAG = "Production";
    public static final String DEVELOP_TAG = "Develop";

    @BeforeAll
    static void beforeAllTest() {
        System.out.println("Cargo a memoria data relevante para mis test");
    }

    @AfterAll
    static void afterAllTest() {
        System.out.println("Elimino archivos o hago revert de algun proceso");
    }

    @BeforeEach
    void beforeEachTest() {
        System.out.println("Ejecuto esto antes de cada test");
    }

    @AfterEach
    void afterEachTest() {
        System.out.println("Ejecuto despues de cada test");
    }

    @Order(2)
    @Tag(DEVELOP_TAG)
    @DisplayName("Demo para estudiantes 2")
    @Test
    void myLastTest() {
        System.out.println("Test 2");
        assertEquals("", "");
    }

    @Order(1)
    @Tags({
            @Tag(PRODUCTION_TAG),
            @Tag(DEVELOP_TAG)
    })
    @DisplayName("Demo para estudiantes 1")
    @Test
    void firstTest() {
        System.out.println("Test 1");
        assertEquals("", "");
    }

    @Nested
    class MyNestedTest {

        @Order(3)
        @Tags({
                @Tag(PRODUCTION_TAG),
                @Tag(DEVELOP_TAG)
        })
        @DisplayName("Demo para estudiantes nested")
        @Test
        void firstTest() {
            System.out.println("Test 3");
            assertEquals("", "");
        }
    }
}

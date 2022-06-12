package edu.aluismarte.diplomado.week7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author aluis on 5/2/2022.
 */
class PrecisionProblemTest {

    private final PrecisionProblem precisionProblem = new PrecisionProblem();

    /**
     * Esta sería la ejecución del ciclo en cuestión
     * <p>
     * 0.0
     * 0.2
     * 0.4
     * 0.6 Se detiene en este valor
     * 0.8
     * 1.0
     */
    @Test
    void noWorkIfTest() {
        double expect = 0.6;
        double sum = precisionProblem.calculareFloatRange(0.0, 1.0, 0.2, expect);
        assertEquals(expect, sum);
    }

    /**
     * Esta sería la ejecución del ciclo en cuestión
     * <p>
     * 0.128
     * 0.256
     * 0.384
     * 0.512 Se detiene en este valor
     * 0.640
     * 0.768
     * 0.896
     * 1.024
     */
    @Test
    void normalTest() {
        double expect = 0.512;
        double sum = precisionProblem.calculareFloatRange(0.0, 1.024, 0.128, expect);
        assertEquals(expect, sum);
    }

    /**
     * Mostrando de forma más simple el problema de precisión que tienen las máquinas
     */
    @Test
    void sumDoublesTest() {
        double a = 0.1;
        double b = 0.2;
        double c = 0.3;
        assertEquals(c, a + b);
    }

}
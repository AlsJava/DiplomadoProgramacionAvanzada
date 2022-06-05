package edu.aluismarte.diplomado.week7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author aluis on 5/2/2022.
 */
class PrecisionProblemTest {

    private final PrecisionProblem precisionProblem = new PrecisionProblem();

    @Test
    void noWorkIfTest() {
        double expect = 0.6;
        double sum = precisionProblem.calculareFloatRange(0.0, 1.0, 0.2, expect);
        assertEquals(expect, sum);
    }

    @Test
    void normalTest() {
        double expect = 0.512;
        double sum = precisionProblem.calculareFloatRange(0.0, 1.024, 0.128, expect);
        assertEquals(expect, sum);
    }

}
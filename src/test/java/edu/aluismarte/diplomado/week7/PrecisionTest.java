package edu.aluismarte.diplomado.week7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class PrecisionTest {

    @Test
    void precisionProblemOnDoubleTest() {
        double a = 0.1;
        double b = 0.2;
        double result = a + b;
        System.out.println("A+B=0.3? or is: " + result);
        assertFalse(result == 0.3); // TODO Why false?
    }
}

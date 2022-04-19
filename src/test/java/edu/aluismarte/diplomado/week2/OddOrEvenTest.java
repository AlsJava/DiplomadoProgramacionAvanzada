package edu.aluismarte.diplomado.week2;

import edu.aluismarte.diplomado.utils.TimeExtension;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Aluis Marte on 11/5/2021.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(TimeExtension.class)
class OddOrEvenTest {

    private final OddOrEven oddOrEven = new OddOrEven();

    private final int evenNumber = 20_000_000;
    private final int oddNumber = 20_000_001;

    @Order(1)
    @Test
    void evenNumberTest() {
        assertTrue(oddOrEven.isEven(evenNumber));
    }

    @Test
    void evenNumberBitwiseORTest() {
        assertTrue(oddOrEven.isEvenBitwiseOR(evenNumber));
    }

    @Test
    void evenNumberBitwiseANDTest() {
        assertTrue(oddOrEven.isEvenBitwiseAND(evenNumber));
    }

    @Order(2)
    @Test
    void oddNumberTest() {
        assertFalse(oddOrEven.isEven(oddNumber));
    }

    @Test
    void oddNumberBitwiseORTest() {
        assertFalse(oddOrEven.isEvenBitwiseOR(oddNumber));
    }

    @Test
    void oddNumberBitwiseANDTest() {
        assertFalse(oddOrEven.isEvenBitwiseAND(oddNumber));
    }

}
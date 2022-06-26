package edu.aluismarte.diplomado.week8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Observamos como el ENUM reduce considerablemente los casos de error y de valores que se pueden recibir
 *
 * @author aluis on 6/4/2022.
 */
class EnumDesignTest {

    private final EnumDesign enumDesign = new EnumDesign();

    @Test
    void nullTest() {
        assertFalse(enumDesign.isValidProvider(null));
    }

    @Test
    void validTest() {
        assertTrue(enumDesign.isValidProvider(EnumDesign.PaymentProvider.PAYPAL));
        assertTrue(enumDesign.isValidProvider(EnumDesign.PaymentProvider.STRIPE));
    }
}

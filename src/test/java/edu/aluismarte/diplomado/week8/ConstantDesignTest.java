package edu.aluismarte.diplomado.week8;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Demostración del problema de diseño que genera el uso de constantes sin tipo de dato estático
 * <p>
 * Listado de fallas de este diseño:
 * - Como se aprecia, el valor a enviar puede ser enviado usando cualquier texto deseado o incluso número
 * - No permite ver con claridad cuáles son los valores esperados
 * - Pueden ocurrir problemas de escritura creando fallas
 *
 * @author aluis on 6/4/2022.
 */
class ConstantDesignTest {

    private final ConstantDesign constantDesign = new ConstantDesign();

    @Nested
    class StringConstantsTest {

        @Test
        void validProviderTest() {
            assertTrue(constantDesign.isValidStringProvider(ConstantDesign.PAYPAL_PROVIDER));
            assertTrue(constantDesign.isValidStringProvider(ConstantDesign.STRIPE_PROVIDER));
        }

        @Test
        void emptyProviderTest() {
            assertFalse(constantDesign.isValidStringProvider(""));
        }

        @Test
        void nullProviderTest() {
            assertFalse(constantDesign.isValidStringProvider(null));
        }

        @Test
        void randomStringProviderTest() {
            assertFalse(constantDesign.isValidStringProvider("sdsdjhnimsd"));
        }

        @Test
        void noConstantStringProviderTest() {
            assertFalse(constantDesign.isValidStringProvider("PAYPAL "));
        }
    }

    @Nested
    class IntegerConstantsTest {

        @Test
        void validProviderTest() {
            assertTrue(constantDesign.isValidIntegerProvider(ConstantDesign.PAYPAL_CONSTANT));
            assertTrue(constantDesign.isValidIntegerProvider(ConstantDesign.STRIPE_CONSTANT));
        }

        @Test
        void negativeProviderTest() {
            assertFalse(constantDesign.isValidIntegerProvider(-1));
        }

        @Test
        void nullProviderTest() {
            assertFalse(constantDesign.isValidIntegerProvider(null));
        }

        @Test
        void randomNumberProviderTest() {
            assertFalse(constantDesign.isValidIntegerProvider(200));
        }
    }
}
package edu.aluismarte.diplomado.week4;

import edu.aluismarte.diplomado.model.week4.Product;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author aluis on 4/3/2022.
 */
public class LogicSeparationTest {

    @Test
    void logicSeparationSaveTest() {
        Product product = Product.builder()
                .id("sads")
                .name("hola")
                .description("Nada")
                .quantity(15)
                .price(new BigDecimal(20))
                .build();
        assertDoesNotThrow(() -> assertNotNull(LogicSeparation.saveProduct(product)));
    }
}

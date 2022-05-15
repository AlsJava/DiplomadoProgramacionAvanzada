package edu.aluismarte.diplomado.week4;

import edu.aluismarte.diplomado.model.week4.Product;
import edu.aluismarte.diplomado.model.week4.RuleError;
import edu.aluismarte.diplomado.utils.RulesTool;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author aluis on 4/3/2022.
 */
public class RulesToolTest {

    /**
     * Ejemplo de como describir un bug
     * Bug con producto duplicado por culpa de la falta de validación del nombre, Verion 1.5.2 2021 Mayo
     */
    @Test
    void bugDuplicateNameTest() {
        Product product = Product.builder().build();
        RuleError ruleError = RulesTool.productFollowRules(product);
        assertEquals(RuleError.NULL_FIELDS, ruleError.getCode());
    }

    @Test
    void nullIdTest() {
        Product product = Product.builder().build();
        RuleError ruleError = RulesTool.productFollowRules(product);
        assertEquals(RuleError.NULL_FIELDS, ruleError.getCode());
    }
}

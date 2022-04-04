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

    @Test
    void nullIdTest() {
        Product product = Product.builder().build();
        RuleError ruleError = RulesTool.productFollowRules(product);
        assertEquals(RuleError.NULL_FIELDS, ruleError.getCode());
    }
}

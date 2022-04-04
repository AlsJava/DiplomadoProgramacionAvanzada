package edu.aluismarte.diplomado.week4;

import edu.aluismarte.diplomado.model.week4.Product;
import edu.aluismarte.diplomado.model.week4.RuleError;
import edu.aluismarte.diplomado.utils.RulesTool;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Ejemplo de código separado
 *
 * @author aluis on 3/27/2022.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LogicSeparation {

    public static Product saveProduct(Product product) throws Exception {
        RuleError ruleError = RulesTool.productFollowRules(product);
        if (!ruleError.getCode().equals(RuleError.OK)) {
            throw new Exception(ruleError.toString());
        }
        return product;
    }
}

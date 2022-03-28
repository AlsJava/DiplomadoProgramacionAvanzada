package edu.aluismarte.diplomado.utils;

import edu.aluismarte.diplomado.model.week4.Product;
import edu.aluismarte.diplomado.model.week4.RuleError;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author aluis on 3/27/2022.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RulesTool {

    public static RuleError productFollowRules(Product product) {
        if (product.getId() == null) {
            return RuleError.builder().code(RuleError.NULL_FIELDS).description("ID is null").build();
        }
        if (product.getName() == null) {
            return RuleError.builder().code(RuleError.NULL_FIELDS).description("Name is null").build();
        }
        if (product.getQuantity() == null) {
            return RuleError.builder().code(RuleError.NULL_FIELDS).description("Quantity is null").build();
        }
        if (product.getPrice() == null) {
            return RuleError.builder().code(RuleError.NULL_FIELDS).description("Price is null").build();
        }
        if (product.getQuantity() < 0) {
            return RuleError.builder().code(RuleError.QUANTITY_ZERO).description("Quantity have to be more4 than zero").build();
        }
        return RuleError.builder().code(RuleError.OK).build();
    }
}

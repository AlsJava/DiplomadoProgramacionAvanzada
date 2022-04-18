package edu.aluismarte.diplomado.week6;

import edu.aluismarte.diplomado.model.week3.LoanType;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author aluis on 4/4/2022.
 */
public class FieldWithToManyCombinationsTest {

    private static final boolean REQUIRED_FIELD = true;
    private static final boolean NO_REQUIRED_FIELD = false;

    private static final boolean COPY_FROM_DEFAULT = true;
    private static final boolean NO_COPY_FROM_DEFAULT = false;

    private final FieldWithToManyCombinations fieldWithToManyCombinations = new FieldWithToManyCombinations();

    @Test
    void requiredFieldTest() {
        assertNull(fieldWithToManyCombinations.formValidation(REQUIRED_FIELD, NO_COPY_FROM_DEFAULT, LoanType.FIXED, null));
    }

    @Test
    void copyFromOldDataTest() {
        assertEquals(LoanType.FIXED, fieldWithToManyCombinations.formValidation(NO_REQUIRED_FIELD, COPY_FROM_DEFAULT, LoanType.FIXED, null));
    }

    @Test
    void emptyTest() {
        assertEquals(BigDecimal.ZERO, fieldWithToManyCombinations.formValidation(NO_REQUIRED_FIELD, NO_COPY_FROM_DEFAULT, new BigDecimal(10000), BigDecimal.ZERO));
    }

}

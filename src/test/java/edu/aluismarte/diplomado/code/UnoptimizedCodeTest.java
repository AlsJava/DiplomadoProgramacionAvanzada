package edu.aluismarte.diplomado.code;

import edu.aluismarte.diplomado.utils.TimeExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * Created by Aluis on 10/18/2021.
 */
@ExtendWith(TimeExtension.class)
class UnoptimizedCodeTest {

    private final UnoptimizedCode unoptimizedCode = new UnoptimizedCode();

    @Test
    void badTest() {
        // Can't test this code, no parameter and no
        unoptimizedCode.calculateDueDate(1);
    }
}
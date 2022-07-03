package edu.aluismarte.diplomado.extra;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author aluis on 7/3/2022.
 */
public class RegexTest {

    private static final String AULA_PATTERN = "^[A-Z]{3,5}-[A-Z]\\d{2}";

    @Test
    void aulaRegexTest() {
        Pattern pattern = Pattern.compile(AULA_PATTERN);
        assertTrue(pattern.matcher("BIBLI-A01").matches());
        assertFalse(pattern.matcher("05BLI-A01").matches());
    }
}

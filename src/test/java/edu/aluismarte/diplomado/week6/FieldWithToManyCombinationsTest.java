package edu.aluismarte.diplomado.week6;

import com.github.javafaker.Faker;
import edu.aluismarte.diplomado.model.week3.LoanType;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author aluis on 4/4/2022.
 * @see <a href="https://www.baeldung.com/parameterized-tests-junit-5">parameterized-tests-junit-5</a>
 * @see <a href="https://www.baeldung.com/junit5-dynamic-tests">junit5-dynamic-tests</a>
 * @see <a href="https://github.com/DiUS/java-faker">Java Faker</a>
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

    @Nested
    class DynamicDataTest {

        @ParameterizedTest
        @CsvFileSource(resources = "/RandomNames.csv", numLinesToSkip = 1)
        void randomNameValueFromFileTest(String name) {
            System.out.println("Using name: " + name);
            assertEquals("", fieldWithToManyCombinations.formValidation(NO_REQUIRED_FIELD, NO_COPY_FROM_DEFAULT, name, ""));
        }

        @ParameterizedTest
        @MethodSource("edu.aluismarte.diplomado.week6.FieldWithToManyCombinationsTest#provideRandomNames") // Usando metodo externo a la clase
        void randomNameValueTest(String name) {
            System.out.println("Using name: " + name);
            assertEquals("", fieldWithToManyCombinations.formValidation(NO_REQUIRED_FIELD, NO_COPY_FROM_DEFAULT, name, ""));
        }

        @TestFactory
        Stream<DynamicTest> dynamicTestStream() {
            Faker faker = new Faker();
            return IntStream.range(0, 20).mapToObj(value -> {
                String name = faker.name().fullName();
                return DynamicTest.dynamicTest("Random name test:" + name, () -> {
                    System.out.println("Using name: " + name);
                    assertEquals("", fieldWithToManyCombinations.formValidation(NO_REQUIRED_FIELD, NO_COPY_FROM_DEFAULT, name, ""));
                });
            });
        }

        @Test
        void handmadeGenerateSomeNamesTest() {
            Faker faker = new Faker();
            for (int i = 0; i < 20; i++) {
                String name = faker.name().fullName();
                System.out.println("Using name: " + name);
                assertEquals("", fieldWithToManyCombinations.formValidation(NO_REQUIRED_FIELD, NO_COPY_FROM_DEFAULT, name, ""));
            }
        }
    }

    static Stream<Arguments> provideRandomNames() {
        Faker faker = new Faker();
        return IntStream.range(0, 20).mapToObj(value -> Arguments.of(faker.name().fullName()));
    }

}

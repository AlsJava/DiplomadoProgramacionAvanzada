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
        assertEquals(LoanType.SAN, fieldWithToManyCombinations.formValidation(NO_REQUIRED_FIELD, COPY_FROM_DEFAULT, LoanType.SAN, null));
    }

    @Test
    void emptyTest() {
        assertEquals(BigDecimal.ZERO, fieldWithToManyCombinations.formValidation(NO_REQUIRED_FIELD, NO_COPY_FROM_DEFAULT, new BigDecimal(10_000), BigDecimal.ZERO));
    }

    @Nested
    class DynamicDataTest {

        /**
         * Puedo tambien usar multiples archivos, con el valor files en caso de que no formen parte del proyecto
         * El hecho de usar mas de un resource es para clasificar mejor la data y organizarla.
         *
         * @param name Nombre a usar para comparar
         */
        @ParameterizedTest
        @CsvFileSource(resources = "/RandomNames.csv", numLinesToSkip = 1)
        void randomNameValueFromFileTest(String name) {
            System.out.println("Using name: " + name);
            assertEquals("", fieldWithToManyCombinations.formValidation(NO_REQUIRED_FIELD, NO_COPY_FROM_DEFAULT, name, ""));
        }

        /**
         * Usando metodo externo a la clase debo usar ese tipo de puntero, Package.Class#Method
         * Si uso un método directo en la misma clase (en caso de ser nested debe ser en la misma) solo uso el nombre del método
         *
         * @param name Nombre a usar para comparar
         */
        @ParameterizedTest
        @MethodSource("edu.aluismarte.diplomado.week6.FieldWithToManyCombinationsTest#provideRandomNames")
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
                    assertEquals("", fieldWithToManyCombinations.formValidation(REQUIRED_FIELD, NO_COPY_FROM_DEFAULT, name, ""));
                    assertEquals(name, fieldWithToManyCombinations.formValidation(NO_REQUIRED_FIELD, COPY_FROM_DEFAULT, name, ""));
                });
            });
        }

        @Test
        void handmadeGenerateSomeNamesTest() {
            Faker faker = new Faker();
            for (int i = 0; i < 20; i++) {
                String name = faker.name().fullName();
                System.out.println("Using name #" + i + ": " + name);
                assertEquals("", fieldWithToManyCombinations.formValidation(NO_REQUIRED_FIELD, NO_COPY_FROM_DEFAULT, name, ""));
            }
        }
    }

    static Stream<Arguments> provideRandomNames() {
        Faker faker = new Faker();
        return IntStream.range(0, 20).mapToObj(value -> Arguments.of(faker.name().fullName()));
    }

}

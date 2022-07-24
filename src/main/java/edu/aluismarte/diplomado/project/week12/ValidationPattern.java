package edu.aluismarte.diplomado.project.week12;

import edu.aluismarte.diplomado.project.domain.Employee;
import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDate;

/**
 * Los request deben tener cuerpo y elementos necesarios y estos deben validarse usando la API correspondiente
 * <p>
 * Al tener un cuerpo definido con los campos obligatorios y los elementos necesarios obtenemos consistencia
 *
 * @author aluis on 6/26/2022.
 */
public class ValidationPattern {

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Getter
    @Setter
    static class CreateEmployeeRequest {


        /**
         * El campo de nombre no puede estar vacío, con esto lo valido en el request
         * Con este hábito que me envíen un espacio vacío
         */
        @NotBlank
        private String name;

        /**
         * Este campo no se valida, no nos interesa, puede llegar null
         */
        private String description;

        /**
         * Este campo jamás puede ser null, siempre necesito una fecha.
         * Tampoco un empleado puede entrar en el pasado, por lo que debe siempre tener una fecha del hoy o futuro
         */
        @NotNull
        @FutureOrPresent
        private LocalDate entryDate;

    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Getter
    @Setter
    static class AnotherExample {

        /**
         * Aquí el campo puede llegar con un espacio como letra (" ")
         */
        @NotEmpty
        private String emptyString;

        /**
         * Aquí el campo no puede llegar con un espacio como letra (" ")
         */
        @NotBlank
        private String emptyStringWithNoSpaceAsVar;

        /**
         * Evito que el objeto sea null en el request, util cuando hablamos de ENUMs y objetos compuestos
         */
        @NotNull
        private Employee employee;

        /**
         * Limito el tamaño del campo, en caso de que asi lo requiera
         */
        @Size(min = 1, max = 200)
        private String description;

        /**
         * Puedo limitar como llega un valor
         */
        @PositiveOrZero
        private int numberOrZero;

        @Positive
        private int numberPositive;

        @NegativeOrZero
        private int numberNegativeOrZero;

        @Negative
        private int numberNegative;

        /**
         * Nunca llegará un número mayor a 2 cifras y 0 cifras después del punto
         */
        @Digits(integer = 2, fraction = 0)
        private double numberWithDigitLimit;

        /**
         * Me aseguro que esto sea un EMAIL o al menos que tenga el cuerpo
         */
        @Email
        private String email;

        /**
         * Lo uso cuando tengo patrones complejos y necesito que un string respete una estructura
         * Ejemplo: BIBLIO-A01, BIBLIO representa el edificio y debe tener 5 o 3 letras, debe luego seguir un "-" y el aula
         */
        @Pattern(regexp = "^[A-Z]{3,5}-[A-Z]\\d{2}")
        private String aula;

    }
}

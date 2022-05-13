package edu.aluismarte.diplomado.week3;

import edu.aluismarte.diplomado.model.week3.Quote;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Aqui deben escribir los test para cubrir la clase correspondiente
 * <p>
 * Debe tener un 100% Coverage
 *
 * @author aluis on 5/1/2022.
 */
public class HomeworkTest {

    private final Homework homework = new Homework();

    /**
     * Con esta función siempre compararás las cuotas.
     * <p>
     * Puedes usar un ciclo for comparando la cada cuota con esta función para que valides que son iguales
     *
     * @param quoteExpected La esperada y con los valores que debería arroja la actual
     * @param quoteActual   La generada por la función
     */
    private void compareQuotes(Quote quoteExpected, Quote quoteActual) {
        assertEquals(quoteExpected.getDate(), quoteActual.getDate());
        assertEquals(quoteExpected.getAmount(), quoteActual.getAmount());
    }

    /**
     * Método de ayuda para generar las quotas.
     *
     * @param date   Fecha
     * @param amount Monto
     * @return cuota esperada
     */
    private Quote createQuote(LocalDate date, BigDecimal amount) {
        return Quote.builder().date(date).amount(amount).build();
    }
}

package edu.aluismarte.diplomado.week7;

import lombok.extern.slf4j.Slf4j;
import org.owasp.encoder.Encode;

/**
 * Verificar que sucede con los logs cuando no se validan las cosas antes de pasarlas
 * <p>
 * Un problema de encode en diversas formas
 *
 * @author aluis on 5/8/2022.
 */
@Slf4j
public class Exercise1Week7 {

    public void worseLog(String parameter) {
        // Forma común que usan los devs cuando no conocen la API de logs.
        System.out.println("My parameter " + parameter);
    }

    public void badLog(String parameter) {
        // Forma común que usan los devs cuando no entienden que las variables se controlan
        log.info("My parameter {}", parameter);
    }

    public void goodLog(String parameter) {
        log.info("My parameter {}", Encode.forJava(parameter));
    }
}

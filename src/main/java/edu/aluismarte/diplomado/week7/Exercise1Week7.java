package edu.aluismarte.diplomado.week7;

import org.owasp.encoder.Encode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Verificar que sucede con los logs cuando no se validan las cosas antes de pasarlas
 * <p>
 * Un problema de encode en diversas formas
 *
 * @author aluis on 5/8/2022.
 */
public class Exercise1Week7 {

    private static final Logger log = LoggerFactory.getLogger(Exercise1Week7.class);

    public void badLog(String parameter) {
        log.info("My parameter {}", parameter);
//        log.info("My parameter {}", Encode.forJava(parameter));
    }
}

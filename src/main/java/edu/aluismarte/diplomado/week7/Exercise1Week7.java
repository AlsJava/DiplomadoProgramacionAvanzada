package edu.aluismarte.diplomado.week7;

import lombok.extern.slf4j.Slf4j;

/**
 * Verificar que sucede con los logs cuando no se validan las cosas antes de pasarlas
 * <p>
 * Un problema de encode en diversas formas
 *
 * @author aluis on 5/8/2022.
 */
@Slf4j
public class Exercise1Week7 {

    public void badLog(String parameter) {
        log.info("My parameter {}", parameter);
//        log.info("My parameter {}", Encode.forJava(parameter));
    }
}

package edu.aluismarte.diplomado.project.week12.exceptions;

import java.text.MessageFormat;

/**
 * Ejemplo de excepción.
 *
 * Siempre debe heredar de RuntimeException, puesto tiene implicaciones relevantes con respecto a las transactions
 *
 * @author aluis on 7/17/2022.
 * @implNote Esto es un ejemplo genérico, siempre debería ser específico, mirar la otra excepción (EmployeeNotFound)
 */
public class NoFoundException extends RuntimeException {

    public NoFoundException(String data) {
        super(MessageFormat.format("Object {0} No found", data));
    }
}

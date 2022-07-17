package edu.aluismarte.diplomado.project.week12.exceptions;

import java.text.MessageFormat;

/**
 * @author aluis on 7/17/2022.
 */
public class EmployeeNotFound extends RuntimeException {

    public EmployeeNotFound(Long idEmployee) {
        super(MessageFormat.format("Employee {0} no found", idEmployee));
    }
}

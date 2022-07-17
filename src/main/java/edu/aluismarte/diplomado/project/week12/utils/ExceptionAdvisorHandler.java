package edu.aluismarte.diplomado.project.week12.utils;

import edu.aluismarte.diplomado.project.week12.exceptions.EmployeeNotFound;
import edu.aluismarte.diplomado.project.week12.exceptions.NoFoundException;
import edu.aluismarte.diplomado.project.week12.model.APIError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Ejemplo de como trabajar las excepciones para retornar al usuario.
 * <p>
 * Cuando una excepción de las registradas aquí ocurra, automáticamente se transformará en el objeto APIError
 * <p>
 * Esto es una forma centralizada de tener control de los errores.
 *
 * @author aluis on 7/17/2022.
 */
@ControllerAdvice
@Slf4j
public class ExceptionAdvisorHandler {

    /**
     * Por cada excepción tengo un método de estos, y les pongo el return code apropiado.
     *
     * @param ex Excepción a manejar
     * @return Un objeto de error, en este caso uno creado para tener respuesta standard.
     */
    @ExceptionHandler(NoFoundException.class)
    public ResponseEntity<APIError> handle(NoFoundException ex) {
        return createResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmployeeNotFound.class)
    public ResponseEntity<APIError> handle(EmployeeNotFound ex) {
        return createResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<APIError> createResponse(String message, HttpStatus httpStatus) {
        log.info("Generating Error {}  and message {}", httpStatus, message);
        APIError apiError = APIError.builder().message(message).status(httpStatus.value()).build();
        return ResponseEntity.status(httpStatus).body(apiError);
    }
}

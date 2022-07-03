package edu.aluismarte.diplomado.model.project;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

/**
 * El uso de property es para hacerlo directo, pero si queremos un tipo de dato especifico como entero
 * usamos el @JsonValue, solo que debemos también definir la lectura
 *
 * @author aluis on 6/26/2022.
 */
@AllArgsConstructor
public enum EmployeeStateJson3 {
    ACTIVE(0),
    FIRED(1),
    PENSIONER(2),
    OUT(3);

    private final int code;

    @JsonValue
    public int getCode() {
        return code;
    }
}

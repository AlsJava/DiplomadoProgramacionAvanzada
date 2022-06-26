package edu.aluismarte.diplomado.model.project;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

/**
 * Este es un ENUM con los 2 elementos necesarios para interactuar con la DB y hacer el JSON
 * <p>
 * Para los JSON se expresan en texto de 2 caracteres
 * Para la DB es un número
 *
 * @author aluis on 6/26/2022.
 */
@AllArgsConstructor
public enum EmployeeState {
    @JsonProperty("A0") ACTIVE(0),
    @JsonProperty("A1") FIRED(1),
    @JsonProperty("A2") PENSIONER(2),
    @JsonProperty("A3") OUT(3);

    private final int code;

    public int getCode() {
        return code;
    }

    public static EmployeeState fromCode(int code) {
        switch (code) {
            case 0:
                return ACTIVE;
            case 1:
                return FIRED;
            case 2:
                return PENSIONER;
            case 3:
                return OUT;
        }
        return null;
    }

}

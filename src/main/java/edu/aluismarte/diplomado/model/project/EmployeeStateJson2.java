package edu.aluismarte.diplomado.model.project;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * El uso de property es para hacerlo directo, también observar la otra opción
 *
 * @author aluis on 6/26/2022.
 */
public enum EmployeeStateJson2 {
    @JsonProperty("0") ACTIVE,
    @JsonProperty("1") FIRED,
    @JsonProperty("2") PENSIONER,
    @JsonProperty("3") OUT
}

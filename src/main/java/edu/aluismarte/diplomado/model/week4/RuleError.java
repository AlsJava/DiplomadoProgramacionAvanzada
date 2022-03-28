package edu.aluismarte.diplomado.model.week4;

import lombok.*;

/**
 * @author aluis on 3/27/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class RuleError {

    public static final String OK = "OK";
    public static final String NULL_FIELDS = "NULL_FIELDS";
    public static final String QUANTITY_ZERO = "QUANTITY_ZERO";

    private String code;
    private String description;
}

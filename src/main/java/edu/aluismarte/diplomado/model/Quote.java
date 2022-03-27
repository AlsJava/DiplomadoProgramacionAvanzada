package edu.aluismarte.diplomado.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author aluis on 3/26/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Quote {

    private BigDecimal amount;
    private LocalDate date;
}

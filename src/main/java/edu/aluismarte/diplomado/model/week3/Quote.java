package edu.aluismarte.diplomado.model.week3;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author aluis on 3/26/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Quote {

    private BigDecimal amount;
    private LocalDate date;
}

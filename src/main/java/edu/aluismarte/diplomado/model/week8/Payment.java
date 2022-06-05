package edu.aluismarte.diplomado.model.week8;

import lombok.*;

import java.math.BigDecimal;

/**
 * @author aluis on 6/4/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Payment {

    private String id;
    private BigDecimal amount;

    private boolean cancel;

    @Builder.Default
    private BigDecimal refund = new BigDecimal(0);
}

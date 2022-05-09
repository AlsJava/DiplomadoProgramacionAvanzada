package edu.aluismarte.diplomado.model.week4;

import lombok.*;

import java.math.BigDecimal;

/**
 * @author aluis on 5/8/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class IceScream {

    private String id;
    private String name;
    private String flavor;
    private BigDecimal amount;
}

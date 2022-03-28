package edu.aluismarte.diplomado.model.week4;

import lombok.*;

import java.math.BigDecimal;

/**
 * @author aluis on 3/27/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Product {

    private String id;
    private String name;
    private String description;

    private Integer quantity;

    private BigDecimal price;

}

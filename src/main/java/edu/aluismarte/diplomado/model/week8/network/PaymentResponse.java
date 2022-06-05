package edu.aluismarte.diplomado.model.week8.network;

import lombok.*;

/**
 * @author aluis on 4/24/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PaymentResponse {

    private String id;
    private String status;
}

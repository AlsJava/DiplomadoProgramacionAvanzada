package edu.aluismarte.diplomado.project.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author aluis on 6/12/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    // TODO falta completar esto aqui

    @Column
    private BigDecimal amount;
}

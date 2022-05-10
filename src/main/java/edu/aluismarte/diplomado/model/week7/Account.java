package edu.aluismarte.diplomado.model.week7;

import lombok.*;

/**
 * @author aluis on 5/9/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Account {

    private String customerName;
    private String accountType;
    private String accountNumber;
    private float balance;
    private Object accountNotes;
}

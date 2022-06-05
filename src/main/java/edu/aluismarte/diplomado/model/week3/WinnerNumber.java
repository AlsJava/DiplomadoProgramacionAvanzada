package edu.aluismarte.diplomado.model.week3;

import lombok.*;

/**
 * @author aluis on 3/26/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class WinnerNumber {

    private String position;
    private String number;

    @Override
    public String toString() {
        return position + ": " + number;
    }
}

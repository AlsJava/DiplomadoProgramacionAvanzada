package edu.aluismarte.diplomado.model.week5;

import lombok.*;

/**
 * @author aluis on 4/3/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode // Necessary when work with maps
@Builder
@ToString
@Getter
@Setter
public class ValidUser {

    private String id;
    private String name;

    private String email;
}

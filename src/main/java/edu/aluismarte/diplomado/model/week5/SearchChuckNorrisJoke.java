package edu.aluismarte.diplomado.model.week5;

import lombok.*;

import java.util.List;

/**
 * @author aluis on 5/1/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class SearchChuckNorrisJoke {

    private int total;
    private List<ChuckNorrisJoke> result;

}

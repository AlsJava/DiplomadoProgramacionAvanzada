package edu.aluismarte.diplomado.week6;

import edu.aluismarte.diplomado.model.week3.WinnerNumber;

import java.util.List;

/**
 * @author aluis on 6/5/2022.
 */
public class LotteryCombination {

    public String createCombination(List<WinnerNumber> winnerNumbers, String combination) {
        StringBuilder result = new StringBuilder();
        for (String num : combination.split("-")) {
            for (WinnerNumber winnerNumber : winnerNumbers) {
                if (winnerNumber.getPosition().equals(num)) {
                    result.append(winnerNumber.getNumber());
                    break;
                }
            }
        }
        return result.toString();
    }
}

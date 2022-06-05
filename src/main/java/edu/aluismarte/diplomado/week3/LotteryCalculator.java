package edu.aluismarte.diplomado.week3;

import edu.aluismarte.diplomado.model.week3.PlayResult;
import edu.aluismarte.diplomado.model.week3.TicketPlay;
import edu.aluismarte.diplomado.model.week3.WinnerNumber;

import java.math.BigDecimal;
import java.util.List;

/**
 * Implementación simplificada de cálculo de lotería para quiniela y pale.
 * <p>
 * Por razones de simpleza no se calculan las tripletas, ya que es demostrativo para test
 * <p>
 * Ejemplo de números ganadores (05-10-25)
 * 05 En primera
 * 10 En segunda
 * 25 En tercera
 *
 * @author aluis on 3/26/2022.
 * @implNote Esta basado en los juegos de lotería en República Dominicana
 */
public class LotteryCalculator {

    public PlayResult calculateTicketPlay(List<WinnerNumber> winnerNumbers, TicketPlay ticketPlay) {
        PlayResult playResult = new PlayResult();
        if (ticketPlay == null) {
            return playResult;
        }
        switch (ticketPlay.getPlay().length()) {
            case 2:
                for (WinnerNumber winnerNumber : winnerNumbers) {
                    if (winnerNumber.getNumber().equals(ticketPlay.getPlay())) {
                        playResult.setCombination(winnerNumber.getPosition());
                        switch (winnerNumber.getPosition()) {
                            case "1" -> playResult.setAmount(new BigDecimal(100).multiply(ticketPlay.getAmount()));
                            case "2" -> playResult.setAmount(new BigDecimal(20).multiply(ticketPlay.getAmount()));
                            case "3" -> playResult.setAmount(new BigDecimal(8).multiply(ticketPlay.getAmount()));
                        }
                        break;
                    }
                }
                break;
            case 4:
                String combination1 = createCombination(winnerNumbers, "1-2");
                String combination2 = createCombination(winnerNumbers, "1-3");
                String combination3 = createCombination(winnerNumbers, "2-3");
                if (combination1.equals(ticketPlay.getPlay())) {
                    playResult.setCombination("1-2");
                    playResult.setAmount(ticketPlay.getAmount().multiply(new BigDecimal(1_000)));
                } else if (combination2.equals(ticketPlay.getPlay())) {
                    playResult.setCombination("1-3");
                    playResult.setAmount(ticketPlay.getAmount().multiply(new BigDecimal(200)));
                } else if (combination3.equals(ticketPlay.getPlay())) {
                    playResult.setCombination("2-3");
                    playResult.setAmount(ticketPlay.getAmount().multiply(new BigDecimal(1_000)));
                }
                break;
            default:
                return null;
        }
        return playResult;
    }

    private String createCombination(List<WinnerNumber> winnerNumbers, String combination) {
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

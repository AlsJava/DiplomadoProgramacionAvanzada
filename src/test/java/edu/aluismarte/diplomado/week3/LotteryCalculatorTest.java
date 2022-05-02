package edu.aluismarte.diplomado.week3;

import edu.aluismarte.diplomado.model.week3.PlayResult;
import edu.aluismarte.diplomado.model.week3.TicketPlay;
import edu.aluismarte.diplomado.model.week3.WinnerNumber;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author aluis on 3/26/2022.
 */
public class LotteryCalculatorTest {

    private static final String PLAY_1 = "10";
    private static final String PLAY_2 = "20";
    private static final String PLAY_3 = "50";

    private static final List<WinnerNumber> SIMPLE_WINNER_NUMBERS = List.of(
            new WinnerNumber("1", PLAY_1),
            new WinnerNumber("2", PLAY_2),
            new WinnerNumber("3", PLAY_3)
    );

    private final LotteryCalculator lotteryCalculator = new LotteryCalculator();

    @Test
    void nullPlay() {
        TicketPlay ticketPlay = null;
        PlayResult playResult = lotteryCalculator.calculateTicketPlay(SIMPLE_WINNER_NUMBERS, ticketPlay);
        assertNull(playResult.getCombination());
        assertNull(playResult.getAmount());
    }

    @Nested
    class QuinielaTest {

        @Test
        void winPosition1Test() {
            TicketPlay ticketPlay = TicketPlay.builder().play(PLAY_1).amount(new BigDecimal(100)).build();
            PlayResult playResult = lotteryCalculator.calculateTicketPlay(SIMPLE_WINNER_NUMBERS, ticketPlay);
            assertEquals("1", playResult.getCombination());
            assertEquals(new BigDecimal(10_000), playResult.getAmount());
        }

        @Test
        void winPosition2Test() {
            TicketPlay ticketPlay = TicketPlay.builder().play(PLAY_2).amount(new BigDecimal(100)).build();
            PlayResult playResult = lotteryCalculator.calculateTicketPlay(SIMPLE_WINNER_NUMBERS, ticketPlay);
            assertEquals("2", playResult.getCombination());
            assertEquals(new BigDecimal(2_000), playResult.getAmount());
        }

        @Test
        void winPosition3Test() {
            TicketPlay ticketPlay = TicketPlay.builder().play(PLAY_3).amount(new BigDecimal(100)).build();
            PlayResult playResult = lotteryCalculator.calculateTicketPlay(SIMPLE_WINNER_NUMBERS, ticketPlay);
            assertEquals("3", playResult.getCombination());
            assertEquals(new BigDecimal(800), playResult.getAmount());
        }

    }

    @Nested
    class PaleTest {

        @Test
        void winPosition12Test() {
            TicketPlay ticketPlay = TicketPlay.builder().play(PLAY_1 + PLAY_2).amount(new BigDecimal(100)).build();
            PlayResult playResult = lotteryCalculator.calculateTicketPlay(SIMPLE_WINNER_NUMBERS, ticketPlay);
            assertEquals("1-2", playResult.getCombination());
            assertEquals(new BigDecimal(100_000), playResult.getAmount());
        }

        @Test
        void winPosition13Test() {
            TicketPlay ticketPlay = TicketPlay.builder().play(PLAY_1 + PLAY_3).amount(new BigDecimal(100)).build();
            PlayResult playResult = lotteryCalculator.calculateTicketPlay(SIMPLE_WINNER_NUMBERS, ticketPlay);
            assertEquals("1-3", playResult.getCombination());
            assertEquals(new BigDecimal(20_000), playResult.getAmount());
        }

        @Test
        void winPosition23Test() {
            TicketPlay ticketPlay = TicketPlay.builder().play(PLAY_2 + PLAY_3).amount(new BigDecimal(100)).build();
            PlayResult playResult = lotteryCalculator.calculateTicketPlay(SIMPLE_WINNER_NUMBERS, ticketPlay);
            assertEquals("2-3", playResult.getCombination());
            assertEquals(new BigDecimal(100_000), playResult.getAmount());
        }
    }

    // TODO Uncomment me to cover 100%
//    @Test
//    void invalidPlay() {
//        TicketPlay ticketPlay = TicketPlay.builder().play(PLAY_1 + PLAY_2 + PLAY_3).amount(new BigDecimal(50)).build();
//        PlayResult playResult = lotteryCalculator.calculateTicketPlay(SIMPLE_WINNER_NUMBERS, ticketPlay);
//        assertNull(playResult);
//    }

}

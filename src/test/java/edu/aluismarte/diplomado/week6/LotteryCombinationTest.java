package edu.aluismarte.diplomado.week6;

import edu.aluismarte.diplomado.model.week3.WinnerNumber;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author aluis on 6/5/2022.
 */
class LotteryCombinationTest {

    private final LotteryCombination lotteryCombination = new LotteryCombination();

    @ParameterizedTest
    @MethodSource("edu.aluismarte.diplomado.week6.LotteryCombinationTest#providePale")
    void calculatePaleTest(List<WinnerNumber> winnerNumbers, String combination, String result) {
        System.out.println("Using combination: " + combination);
        assertEquals(result, lotteryCombination.createCombination(winnerNumbers, combination));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Pales.csv")
    void calculatePaleFromFileTest(String winnerNumbersText, String combination, String result) {
        System.out.println("Using combination: " + combination);
        List<WinnerNumber> winnerNumbers = new ArrayList<>();
        for (String row : winnerNumbersText.split("\\|")) {
            String[] split = row.split(":");
            winnerNumbers.add(new WinnerNumber(split[0], split[1]));
        }
        assertEquals(result, lotteryCombination.createCombination(winnerNumbers, combination));
    }

    static Stream<Arguments> providePale() {
        String NUM1 = "15";
        String NUM2 = "25";
        String NUM3 = "00";
        List<WinnerNumber> winnerNumbers = List.of(
                new WinnerNumber("1", NUM1),
                new WinnerNumber("2", NUM2),
                new WinnerNumber("3", NUM3)
        );
        List<WinnerNumber> winnerNumbers2 = List.of(
                new WinnerNumber("1", "10"),
                new WinnerNumber("2", "60"),
                new WinnerNumber("3", "95")
        );
        return Stream.of(
                Arguments.of(winnerNumbers, "1-2", NUM1 + NUM2),
                Arguments.of(winnerNumbers, "1-3", NUM1 + NUM3),
                Arguments.of(winnerNumbers, "2-3", NUM2 + NUM3),

                Arguments.of(winnerNumbers2, "1-2", "1060"),
                Arguments.of(winnerNumbers2, "1-3", "1095"),
                Arguments.of(winnerNumbers2, "2-3", "6095")
        );
    }

}
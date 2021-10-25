package edu.aluismarte.diplomado.code;

import edu.aluismarte.diplomado.Data;
import edu.aluismarte.diplomado.model.Holiday;
import edu.aluismarte.diplomado.utils.TimeExtension;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JANUARY 1, 2021 is FRIDAY
 * <p>
 * Created by Aluis on 10/18/2021.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(TimeExtension.class)
class OptimizeCodeTest {

    private final OptimizeCode optimizeCode = new OptimizeCode();

    @Order(1)
    @Test
    void oneYearWith10LaborDaysTest() {
        LocalDate startDate = LocalDate.of(2021, Month.JANUARY, 1);
        startDate.datesUntil(LocalDate.of(2021, Month.DECEMBER, 31)).forEach(new Consumer<LocalDate>() {
            @Override
            public void accept(LocalDate date) {
                optimizeCode.calculateDueDateWithMemory(Data.HOLIDAYS, date, 10);
            }
        });
    }

    @Test
    void noHolidaysTest() {
        LocalDate startDate = LocalDate.of(2021, Month.JANUARY, 1);
        LocalDate localDate = optimizeCode.calculateDueDateWithMemory(startDate, 2);
        assertEquals(LocalDate.of(2021, Month.JANUARY, 4), localDate);
    }

    @Test
    void twoHolidaysTogetherTest() {
        List<Holiday> holidays = List.of(
                new Holiday("Consecutive 1", LocalDate.of(2021, Month.JANUARY, 6)),
                new Holiday("Consecutive 2", LocalDate.of(2021, Month.JANUARY, 7))
        );
        LocalDate startDate = LocalDate.of(2021, Month.JANUARY, 1);
        LocalDate localDate = optimizeCode.calculateDueDateWithMemory(holidays, startDate, 4);
        assertEquals(LocalDate.of(2021, Month.JANUARY, 8), localDate);
    }

    @Test
    void startWeekendTest() {
        LocalDate startDate = LocalDate.of(2021, Month.JANUARY, 2);
        LocalDate localDate = optimizeCode.calculateDueDateWithMemory(Data.HOLIDAYS, startDate, 1);
        assertEquals(LocalDate.of(2021, Month.JANUARY, 4), localDate);
    }

}
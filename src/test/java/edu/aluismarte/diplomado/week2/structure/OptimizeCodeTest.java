package edu.aluismarte.diplomado.week2.structure;

import edu.aluismarte.diplomado.utils.Data;
import edu.aluismarte.diplomado.utils.TimeExtension;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JANUARY 1, 2021 is FRIDAY
 * <p>
 * Created by Aluis on 10/18/2021.
 */
@ExtendWith(TimeExtension.class)
class OptimizeCodeTest {

    private final OptimizeCode optimizeCode = new OptimizeCode();

    @Order(1)
    @Test
    void oneYearWith10LaborDaysTest() {
        LocalDate startDate = LocalDate.of(2021, Month.JANUARY, 1);
        startDate.datesUntil(LocalDate.of(2021, Month.DECEMBER, 31))
                .forEach(date -> optimizeCode.calculateDueDateNoMemory(Data.HOLIDAYS, date, 10));
    }

    @Test
    void noHolidaysTest() {
        LocalDate startDate = LocalDate.of(2021, Month.JANUARY, 1);
        LocalDate localDate = optimizeCode.calculateDueDateNoMemory(startDate, 2);
        assertEquals(LocalDate.of(2021, Month.JANUARY, 5), localDate);
    }

    @Test
    void startWeekendTest() {
        LocalDate startDate = LocalDate.of(2021, Month.JANUARY, 2);
        LocalDate localDate = optimizeCode.calculateDueDateNoMemory(Data.HOLIDAYS, startDate, 1);
        assertEquals(LocalDate.of(2021, Month.JANUARY, 5), localDate);
    }

    @Test
    void twoHolidaysTogetherTest() {
        LocalDate startDate = LocalDate.of(2021, Month.JANUARY, 1);
        LocalDate localDate = optimizeCode.calculateDueDateNoMemory(Data.HOLIDAYS, startDate, 4);
        assertEquals(LocalDate.of(2021, Month.JANUARY, 11), localDate);
    }

}
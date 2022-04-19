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
 * @author Aluis Marte on 11/5/2021.
 */
@ExtendWith(TimeExtension.class)
class OptimizeCode2Test {

    private final OptimizeCode2 optimizeCode = new OptimizeCode2();

    @Order(1)
    @Test
    void oneYearWith10LaborDaysTest() {
        LocalDate startDate = LocalDate.of(2021, Month.JANUARY, 1);
        startDate.datesUntil(LocalDate.of(2021, Month.DECEMBER, 31))
                .forEach(date -> optimizeCode.calculateDueDateWithMemory(Data.HOLIDAYS, date, 10));
    }

    @Test
    void noHolidaysTest() {
        LocalDate startDate = LocalDate.of(2021, Month.JANUARY, 1);
        LocalDate localDate = optimizeCode.calculateDueDateWithMemory(startDate, 2);
        assertEquals(LocalDate.of(2021, Month.JANUARY, 5), localDate);
    }

    @Test
    void startWeekendTest() {
        LocalDate startDate = LocalDate.of(2021, Month.JANUARY, 2);
        LocalDate localDate = optimizeCode.calculateDueDateWithMemory(Data.HOLIDAYS, startDate, 1);
        assertEquals(LocalDate.of(2021, Month.JANUARY, 5), localDate);
    }

    @Test
    void twoHolidaysTogetherTest() {
        LocalDate startDate = LocalDate.of(2021, Month.JANUARY, 1);
        LocalDate localDate = optimizeCode.calculateDueDateWithMemory(Data.HOLIDAYS, startDate, 4);
        assertEquals(LocalDate.of(2021, Month.JANUARY, 11), localDate);
    }

}
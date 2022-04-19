package edu.aluismarte.diplomado.week2.structure;

import edu.aluismarte.diplomado.utils.TimeExtension;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Aluis on 10/18/2021.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(TimeExtension.class)
class UnoptimizedCodeTest {

    private final UnoptimizedCode unoptimizedCode = new UnoptimizedCode();

    @Order(1)
    @Test
    void oneYearWith10LaborDaysTest() {
        LocalDate startDate = LocalDate.of(2021, Month.JANUARY, 1);
        startDate.datesUntil(LocalDate.of(2021, Month.DECEMBER, 31))
                .forEach(date -> unoptimizedCode.calculateDueDate(java.sql.Date.valueOf(date), 10));
    }

    @Test
    void noHolidaysTest() {
        LocalDate startDate = LocalDate.of(2021, Month.JANUARY, 1);
        Date date = unoptimizedCode.calculateDueDate(java.sql.Date.valueOf(startDate), 2);
        assertEquals(LocalDate.of(2021, Month.JANUARY, 4), new java.sql.Date(date.getTime()).toLocalDate());
    }

    @Test
    void startWeekendTest() {
        LocalDate startDate = LocalDate.of(2021, Month.JANUARY, 2);
        Date date = unoptimizedCode.calculateDueDate(java.sql.Date.valueOf(startDate), 1);
        assertEquals(LocalDate.of(2021, Month.JANUARY, 4), new java.sql.Date(date.getTime()).toLocalDate());
    }

    @Test
    void twoHolidaysTogetherTest() {
        // Fail test
        LocalDate startDate = LocalDate.of(2021, Month.JANUARY, 1);
        Date date = unoptimizedCode.calculateDueDate(java.sql.Date.valueOf(startDate), 4);
        assertEquals(LocalDate.of(2021, Month.JANUARY, 11), new java.sql.Date(date.getTime()).toLocalDate());
    }

}
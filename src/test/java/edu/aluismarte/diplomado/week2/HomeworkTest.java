package edu.aluismarte.diplomado.week2;

import edu.aluismarte.diplomado.model.week2.Holiday;
import edu.aluismarte.diplomado.utils.Data;
import edu.aluismarte.diplomado.utils.TimeExtension;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author aluis on 5/1/2022.
 */
@ExtendWith(TimeExtension.class)
class HomeworkTest {

    private final Homework homework = new Homework();

    @Nested
    class FiveDaysLaborWeek {

        private final List<DayOfWeek> workdays = List.of(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY);

        @Test
        void noHolidaysTest() {
            LocalDate startDate = LocalDate.of(2021, Month.JANUARY, 1);
            LocalDate localDate = homework.calculateDueDate(workdays, new ArrayList<>(), startDate, 2);
            assertEquals(LocalDate.of(2021, Month.JANUARY, 5), localDate);
        }

        @Test
        void startWeekendTest() {
            LocalDate startDate = LocalDate.of(2021, Month.JANUARY, 2);
            LocalDate localDate = homework.calculateDueDate(workdays, Data.HOLIDAYS, startDate, 1);
            assertEquals(LocalDate.of(2021, Month.JANUARY, 5), localDate);
        }

        @Test
        void twoHolidaysTogetherTest() {
            LocalDate startDate = LocalDate.of(2021, Month.JANUARY, 1);
            LocalDate localDate = homework.calculateDueDate(workdays, Data.HOLIDAYS, startDate, 4);
            assertEquals(LocalDate.of(2021, Month.JANUARY, 11), localDate);
        }

        @Test
        void betweenHolidaysTest() {
            List<Holiday> holidays = List.of(
                    new Holiday("Test 1", LocalDate.of(2021, Month.JANUARY, 4)),
                    new Holiday("Test 1", LocalDate.of(2021, Month.JANUARY, 6))
            );
            LocalDate startDate = LocalDate.of(2021, Month.JANUARY, 1);
            LocalDate localDate = homework.calculateDueDate(workdays, holidays, startDate, 4);
            assertEquals(LocalDate.of(2021, Month.JANUARY, 11), localDate);
        }
    }

    @Nested
    class ThreeDaysLaborWeek {

        private final List<DayOfWeek> workdays = List.of(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY);

        @Test
        void noHolidaysTest() {
            LocalDate startDate = LocalDate.of(2021, Month.JANUARY, 1);
            LocalDate localDate = homework.calculateDueDate(workdays, new ArrayList<>(), startDate, 2);
            assertEquals(LocalDate.of(2021, Month.JANUARY, 6), localDate);
        }

        @Test
        void startWeekendTest() {
            LocalDate startDate = LocalDate.of(2021, Month.JANUARY, 2);
            LocalDate localDate = homework.calculateDueDate(workdays, Data.HOLIDAYS, startDate, 1);
            assertEquals(LocalDate.of(2021, Month.JANUARY, 5), localDate);
        }

        @Test
        void twoHolidaysTogetherTest() {
            List<Holiday> holidays = List.of(
                    new Holiday("Test 1", LocalDate.of(2021, Month.JANUARY, 12)),
                    new Holiday("Test 2", LocalDate.of(2021, Month.JANUARY, 13))
            );
            LocalDate startDate = LocalDate.of(2021, Month.JANUARY, 1);
            LocalDate localDate = homework.calculateDueDate(workdays, holidays, startDate, 4);
            assertEquals(LocalDate.of(2021, Month.JANUARY, 18), localDate);
        }

        @Test
        void betweenHolidaysTest() {
            List<Holiday> holidays = List.of(
                    new Holiday("Test 1", LocalDate.of(2021, Month.JANUARY, 11)),
                    new Holiday("Test 1", LocalDate.of(2021, Month.JANUARY, 13))
            );
            LocalDate startDate = LocalDate.of(2021, Month.JANUARY, 1);
            LocalDate localDate = homework.calculateDueDate(workdays, holidays, startDate, 4);
            assertEquals(LocalDate.of(2021, Month.JANUARY, 18), localDate);
        }
    }

}
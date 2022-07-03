package edu.aluismarte.diplomado.extra;

import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author aluis on 7/3/2022.
 */
public class DateTest {

    private static final Time closeTime = convertToTime(LocalTime.of(23, 50, 0));

    /**
     * Simple problem, but need understand to detect the fail
     */
    @Test
    void problemCompareDatesOldAPIJava() {
        Date actual = new Date(); // Normal lazy way to get actual date
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(actual);
        calendar.clear(Calendar.HOUR);
        calendar.clear(Calendar.MINUTE);
        calendar.clear(Calendar.SECOND);
        calendar.clear(Calendar.MILLISECOND);
        Date dateWithoutTimePart = calendar.getTime(); // Same date, but time part zero, normal case on date comes from JSON parse without time part and Time Zone.
        System.out.println(dateWithoutTimePart.getTime());
        System.out.println(actual.getTime());
        // Working on problems that use this comparator, give more problems
        // Dates are mutable and see the problem on big projects is maybe imposible
        // use same date case on diferent time zone, can give you an extra problem parse
        assertEquals(-1, dateWithoutTimePart.compareTo(actual));

    }

    @Test
    void epicTimeCompareOldAPIJava() {
        Date actual = new Date();
        // Extended case to understand dates!
        // public class Time extends java.util.Date
        // Why!!!! they do that?
        Time time = new Time(actual.getTime()); // Hour on use in the day
        Time equalTimeFork = Time.valueOf(time.toString()); // Same time?
        assertEquals(1, time.compareTo(equalTimeFork)); // Not equals, epic fail
    }

    @Test
    void timeTest() {
        Time actualTime = convertToTime(LocalTime.of(22, 45, 0));
        assertFalse(closeTime.compareTo(actualTime) <= 0);
    }

    @Test
    void convertDateTimeTest() {
        // No es correcto, debio dar un false, pero por la forma en que se compara en el API viejo de java da un true;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 22);
        calendar.set(Calendar.MINUTE, 45);
        calendar.set(Calendar.SECOND, 0);
        Time actualTime = new Time(calendar.getTime().getTime());
        assertTrue(closeTime.compareTo(actualTime) <= 0);
    }


    public static Time convertToTime(LocalTime localTime) {
        if (localTime == null) {
            return null;
        }
        return Time.valueOf(localTime);
    }
}

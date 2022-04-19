package edu.aluismarte.diplomado.week2.structure;

import edu.aluismarte.diplomado.model.week2.Holiday;
import edu.aluismarte.diplomado.utils.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * Optimize code to calculate due date
 * <p>
 * Created by Aluis on 10/18/2021.
 */
public class OptimizeCode2 {

    private static final Map<LocalDate, Integer> LABOR_DAYS = new ConcurrentHashMap<>();

    /**
     * @param startDate Date to start to count
     * @param vacation  Number of vacation days
     * @return Return date to office
     */
    public LocalDate calculateDueDateWithMemory(LocalDate startDate, int vacation) {
        List<Holiday> holidays = getHolidays(startDate, startDate.plusDays(vacation * 3L)); // Find 3 times days on holidays then workdays
        return calculateDueDateWithMemory(holidays, startDate, vacation);
    }

    public LocalDate calculateDueDateWithMemory(List<Holiday> holidays, LocalDate startDate, int vacation) {
        LocalDate result = startDate; // Its immutable data type
        int laborDays = 0;
        while (true) {
            laborDays += getIsLaborDay(holidays, result);
            if (laborDays <= vacation) {
                result = result.plusDays(1);
            } else {
                break;
            }
        }
        return result;
    }

    private List<Holiday> getHolidays(LocalDate startDate, LocalDate endDate) {
        return Data.HOLIDAYS.stream()
                .filter(holiday -> holiday.getDate().compareTo(startDate) >= 0 && holiday.getDate().compareTo(endDate) <= 0)
                .collect(Collectors.toList());
    }

    private int getIsLaborDay(List<Holiday> holidays, LocalDate dateToFind) {
        return LABOR_DAYS.computeIfAbsent(dateToFind, date -> {
            if (holidays.stream().anyMatch(holiday -> holiday.getDate().isEqual(date))) {
                return 0;
            }
            return switch (date.getDayOfWeek()) {
                case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> 1;
                case SATURDAY, SUNDAY -> 0;
            };
        });
    }
}

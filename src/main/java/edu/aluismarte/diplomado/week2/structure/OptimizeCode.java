package edu.aluismarte.diplomado.week2.structure;

import edu.aluismarte.diplomado.model.week2.Holiday;
import edu.aluismarte.diplomado.utils.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Optimize code to calculate due date
 * <p>
 * Created by Aluis on 10/18/2021.
 */
public class OptimizeCode {

    /**
     * @param startDate Date to start to count
     * @param vacation  Number of vacation days
     * @return Return date to office
     */
    public LocalDate calculateDueDateNoMemory(LocalDate startDate, int vacation) {
        List<Holiday> holidays = getHolidays(startDate, startDate.plusDays(vacation * 3L)); // Find 3 times days on holidays then workdays
        return calculateDueDateNoMemory(holidays, startDate, vacation);
    }

    public LocalDate calculateDueDateNoMemory(List<Holiday> holidays, LocalDate startDate, int vacation) {
        LocalDate result = startDate; // Its immutable data type
        int laborDays = 0;
        while (true) {
            if (isHoliday(holidays, result)) {
                // When validate a holiday be sure, maybe we have continues holidays, the reason of IF
                result = result.plusDays(1); // Skip holiday
            } else {
                switch (result.getDayOfWeek()) {
                    case MONDAY:
                    case TUESDAY:
                    case WEDNESDAY:
                    case THURSDAY:
                    case FRIDAY:
                        laborDays++; // Count only labor day
                        break;
                    case SATURDAY:
                    case SUNDAY:
                        break;
                }
            }
            if (laborDays <= vacation) {
                result = result.plusDays(1);
            } else {
                break;
            }
        }
        return result;
    }

    private boolean isHoliday(List<Holiday> holidays, LocalDate date) {
        return holidays.stream().anyMatch(holiday -> holiday.getDate().isEqual(date));
    }

    private List<Holiday> getHolidays(LocalDate startDate, LocalDate endDate) {
        return Data.HOLIDAYS.stream()
                .filter(holiday -> holiday.getDate().compareTo(startDate) >= 0 && holiday.getDate().compareTo(endDate) <= 0)
                .collect(Collectors.toList());
    }
}

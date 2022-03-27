package edu.aluismarte.diplomado.week2.structure;

import edu.aluismarte.diplomado.utils.Data;
import edu.aluismarte.diplomado.model.Holiday;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * No optimize code to calculate due date
 * <p>
 * Created by Aluis on 10/18/2021.
 */
public class UnoptimizedCode {

    public Date calculateDueDate(Date startDate, int daysToWait) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        for (int i = 0; i < daysToWait; i++) {
            switch (calendar.get(Calendar.DAY_OF_WEEK)) {
                case Calendar.MONDAY:
                case Calendar.TUESDAY:
                case Calendar.WEDNESDAY:
                case Calendar.THURSDAY:
                case Calendar.FRIDAY:
                    calendar.add(Calendar.DATE, 1);
                    break;
                case Calendar.SATURDAY:
                    calendar.add(Calendar.DATE, 2);
                    break;
                case Calendar.SUNDAY:
                    calendar.add(Calendar.DATE, 1);
                    break;
            }
        }
        List<Holiday> holidays = getHolidays(calendar.getTime()); // Find holidays to this date
        for (Holiday holiDay : holidays) {
            LocalDate holyDate = holiDay.getDate();
            switch (holyDate.getDayOfWeek()) {
                case MONDAY:
                case TUESDAY:
                case WEDNESDAY:
                case THURSDAY:
                case FRIDAY:
                    calendar.add(Calendar.DATE, 1);
                    break;
                case SATURDAY:
                    calendar.add(Calendar.DATE, 1);
                    break;
                case SUNDAY:
                    calendar.add(Calendar.DATE, 2);
                    break;
            }
        }
        return calendar.getTime();
    }

    /**
     * Get Holidays on a year
     *
     * @return List of available holidays
     */
    private List<Holiday> getHolidays(Date lastDate) {
        return Data.HOLIDAYS.stream().filter(holiday -> {
            LocalDate localDate = LocalDate.from(new java.sql.Date(lastDate.getTime()).toLocalDate());
            return holiday.getDate().isBefore(localDate) || holiday.getDate().equals(localDate);
        }).collect(Collectors.toList());
    }
}

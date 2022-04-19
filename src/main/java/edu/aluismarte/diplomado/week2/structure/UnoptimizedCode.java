package edu.aluismarte.diplomado.week2.structure;

import edu.aluismarte.diplomado.model.week2.Holiday;
import edu.aluismarte.diplomado.utils.Data;

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

    /**
     * @param startDate Date to start to count
     * @param vacation  Number of vacation days
     * @return Return date to office
     */
    public Date calculateDueDate(Date startDate, int vacation) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        for (int i = 0; i < vacation; i++) {
            switch (calendar.get(Calendar.DAY_OF_WEEK)) {
                case Calendar.MONDAY, Calendar.TUESDAY, Calendar.WEDNESDAY, Calendar.THURSDAY, Calendar.FRIDAY ->
                        calendar.add(Calendar.DATE, 1);
                case Calendar.SATURDAY -> calendar.add(Calendar.DATE, 2);
                case Calendar.SUNDAY -> calendar.add(Calendar.DATE, 1);
            }
        }
        List<Holiday> holidays = getHolidays(calendar.getTime()); // Find holidays to this date
        for (Holiday holiDay : holidays) {
            LocalDate holyDate = holiDay.getDate();
            switch (holyDate.getDayOfWeek()) {
                case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> calendar.add(Calendar.DATE, 1);
                case SATURDAY -> calendar.add(Calendar.DATE, 1);
                case SUNDAY -> calendar.add(Calendar.DATE, 2);
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

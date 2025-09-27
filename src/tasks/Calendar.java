package tasks;

import java.time.LocalDate;


public class Calendar {
    public static String getDay(int day, int year) {
        LocalDate date = LocalDate.of(year, 1, 1).plusDays(day - 1);
        return date.getDayOfWeek().toString() + " " + date.getDayOfMonth() + " " + date.getMonth();
    }
}

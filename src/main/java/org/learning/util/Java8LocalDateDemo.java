package org.learning.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Java8LocalDateDemo {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();

        // other way to define LocalDate
        LocalDate localDate2 = LocalDate.of(2015, 02, 20);

        // other way to define LocalDate
        LocalDate localDate3 =  LocalDate.parse("2015-02-20");

        LocalDate tomorrow = LocalDate.now().plusDays(1);

        // get current date and subtract one month
        LocalDate previousMonthSameDay = LocalDate.now().minus(1, ChronoUnit.MONTHS);

        DayOfWeek sunday = LocalDate.parse("2016-06-12").getDayOfWeek();

        int twelve = LocalDate.parse("2016-06-12").getDayOfMonth();

        boolean leapYear = LocalDate.now().isLeapYear();

        boolean notBefore = LocalDate.parse("2016-06-12")
                .isBefore(LocalDate.parse("2016-06-11"));

        boolean isAfter = LocalDate.parse("2016-06-12")
                .isAfter(LocalDate.parse("2016-06-11"));
    }
}

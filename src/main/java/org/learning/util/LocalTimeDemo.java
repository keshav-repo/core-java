package org.learning.util;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class LocalTimeDemo {
    public static void main(String[] args) {
        LocalTime now = LocalTime.now();

        LocalTime sixThirty = LocalTime.parse("06:30");

        LocalTime sixThirty2 = LocalTime.of(6, 30);

        LocalTime sevenThirty = LocalTime.parse("06:30").plus(1, ChronoUnit.HOURS);

        int six = LocalTime.parse("06:30").getHour();

        boolean isbefore = LocalTime.parse("06:30").isBefore(LocalTime.parse("07:30"));

        LocalTime maxTime = LocalTime.MAX;
    }
}

package org.learning.util;

import java.time.*;
import java.util.Set;

public class LocalDateTimeDemo {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();

        LocalDateTime dateTime2 = LocalDateTime.of(2015, Month.FEBRUARY, 20, 06, 30);

        LocalDateTime dateTime3 = LocalDateTime.parse("2015-02-20T06:30:00");

        localDateTime = localDateTime.plusDays(1);

        localDateTime = localDateTime.minusHours(2);

        Month month = localDateTime.getMonth();

        OffsetDateTime utcDateTime = localDateTime.atOffset(ZoneOffset.UTC);

        ZoneId zoneId = ZoneId.of("Europe/Paris");

        Set<String> allZoneIds = ZoneId.getAvailableZoneIds();

        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);

        ZonedDateTime zonedDateTime2 = ZonedDateTime.parse("2015-05-03T10:15:30+01:00[Europe/Paris]");

        LocalDateTime localDateTime3 = LocalDateTime.of(2015, Month.FEBRUARY, 20, 06, 30);

        ZoneOffset offset = ZoneOffset.of("+02:00");

        OffsetDateTime offSetByTwo = OffsetDateTime.of(localDateTime, offset);

    }
}

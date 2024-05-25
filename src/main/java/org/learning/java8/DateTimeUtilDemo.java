package org.learning.java8;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class DateTimeUtilDemo {
    public static void main(String[] args) {
//        Set<String> zoneList =  ZoneId.getAvailableZoneIds();
//        System.out.println(zoneList);
//
//        LocalDateTime localDateTime = LocalDateTime.now();
//        ZonedDateTime zonedDateTime =  localDateTime.atZone(ZoneId.of("UTC"));
//
//        System.out.println(zonedDateTime);

        String charSeq = "2024-05-13 07:27:50";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                .withZone(ZoneId.of("UTC"));

       ZonedDateTime dateTime =  ZonedDateTime.parse(charSeq, dateTimeFormatter);
        System.out.println(dateTime);

    }
}

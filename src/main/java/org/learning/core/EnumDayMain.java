package org.learning.core;

enum DayOfWeek {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}

public class EnumDayMain {
    public static void main(String[] args) {
        // iterate
        for (DayOfWeek day : DayOfWeek.values()) {
            System.out.println(day);
        }

        // search element
        String searchValue = "WEDNESDAY";
        DayOfWeek[] daysOfWeek = DayOfWeek.values();

        for (DayOfWeek day : daysOfWeek) {
            if (day.name().equals(searchValue)) {
                System.out.println("Found: " + day);
                break;
            }
        }

        // swith statement
        DayOfWeek day = DayOfWeek.FRIDAY;

        switch (day) {
            case MONDAY:
                System.out.println("It's Monday!");
                break;
            case TUESDAY:
                System.out.println("It's Tuesday!");
                break;
            case WEDNESDAY:
                System.out.println("It's Wednesday!");
                break;
            case THURSDAY:
                System.out.println("It's Thursday!");
                break;
            case FRIDAY:
                System.out.println("It's Friday!");
                break;
            case SATURDAY:
                System.out.println("It's Saturday!");
                break;
            case SUNDAY:
                System.out.println("It's Sunday!");
                break;
            default:
                System.out.println("Invalid day!");
        }


    }
}

package com.javarush.task.task40.task4008;

/* 
Работа с Java 8 DateTime API
*/

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

public class Solution {
    public static void main(String[] args) {
        //printDate("21.4.2014 15:56:45");
        printDate("9.10.2017 5:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        String[] dateArr = date.split(" ");
        LocalDate localDate = null;
        LocalTime localTime = null;
        if (dateArr.length == 2) {
            localDate = LocalDate.parse(dateArr[0], DateTimeFormatter.ofPattern("d.M.yyyy"));
            localTime = LocalTime.parse(dateArr[1], DateTimeFormatter.ofPattern("H:mm:ss"));
        } else if (date.contains(".")) {
            localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("d.M.yyyy"));
        } else {
            localTime = LocalTime.parse(date, DateTimeFormatter.ofPattern("H:mm:ss"));
        }
        if (localDate != null) {
            System.out.println("День: " + localDate.getDayOfMonth());
            System.out.println("День недели: " + localDate.getDayOfWeek().getValue());
            System.out.println("День месяца: " + localDate.getDayOfMonth());
            System.out.println("День года: " + localDate.getDayOfYear());
            System.out.println("Неделя месяца: " + localDate.get(ChronoField.ALIGNED_WEEK_OF_MONTH));
            System.out.println("Неделя года: " + localDate.get(ChronoField.ALIGNED_WEEK_OF_YEAR));
            System.out.println("Месяц: " + localDate.getMonth().getValue());
            System.out.println("Год: " + localDate.getYear());
        }
        if (localTime != null) {
            String amPm = localTime.get(ChronoField.AMPM_OF_DAY) == 0 ? "AM" : "PM";
            System.out.println("AM или PM: " + amPm);
            System.out.println("Часы: " + localTime.get(ChronoField.HOUR_OF_AMPM));
            System.out.println("Часы дня: " + localTime.get(ChronoField.HOUR_OF_DAY));
            System.out.println("Минуты: " + localTime.getMinute());
            System.out.println("Секунды: " + localTime.getSecond());
        }
    }
}

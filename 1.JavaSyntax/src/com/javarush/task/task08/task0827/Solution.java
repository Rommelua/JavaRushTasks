package com.javarush.task.task08.task0827;

/* 
Работа с датой
*/

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) {

        System.out.println(isDateOdd("MAY 1 2013"));
        //System.out.println(isDateOdd("Feb 1 2013"));

    }

    public static boolean isDateOdd(String date) {
        DateTimeFormatter format = new DateTimeFormatterBuilder().parseCaseInsensitive()
                .appendPattern("MMMM d yyyy").toFormatter(Locale.US);
        LocalDate ld = LocalDate.parse(date, format);
        return ld.getDayOfYear() % 2 != 0;
    }
}

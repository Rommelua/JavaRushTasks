package com.javarush.task.task40.task4007;

/* 
Работа с датами
*/

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        DateFormat dateTimeF = new SimpleDateFormat("dd.M.yyyy HH:mm:ss");
        DateFormat dateF = new SimpleDateFormat("dd.M.yyyy");
        DateFormat timeF = new SimpleDateFormat("HH:mm:ss");
        DateFormat amPm = new SimpleDateFormat("a");
        Calendar calendar = Calendar.getInstance();
        try{
            calendar.setTime(dateTimeF.parse(date));
            printDate(calendar);
            printTime(amPm, calendar);
            return;
        } catch (ParseException e) {
        }
        try{
            calendar.setTime(dateF.parse(date));
            printDate(calendar);
        } catch (ParseException e) {
        }
        try{
            calendar.setTime(timeF.parse(date));
            printTime(amPm, calendar);
        } catch (ParseException e) {
        }
    }

    private static void printTime(DateFormat amPm, Calendar calendar) {
        System.out.println("AM или PM: " + amPm.format(calendar.getTime()));
        System.out.println("Часы: " + calendar.get(Calendar.HOUR));
        System.out.println("Часы дня: " + calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("Минуты: " + calendar.get(Calendar.MINUTE));
        System.out.println("Секунды: " + calendar.get(Calendar.SECOND));
    }

    private static void printDate(Calendar calendar) {
        System.out.println("День: " + calendar.get(Calendar.DAY_OF_MONTH));
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) == 1 ? 7 : calendar.get(Calendar.DAY_OF_WEEK) - 1;
        System.out.println("День недели: " + dayOfWeek);
        System.out.println("День месяца: " + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("День года: " + calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println("Неделя месяца: " + calendar.get(Calendar.WEEK_OF_MONTH));
        System.out.println("Неделя года: " + calendar.get(Calendar.WEEK_OF_YEAR));
        System.out.println("Месяц: " + (calendar.get(Calendar.MONTH) + 1));
        System.out.println("Год: " + calendar.get(Calendar.YEAR));
    }
}

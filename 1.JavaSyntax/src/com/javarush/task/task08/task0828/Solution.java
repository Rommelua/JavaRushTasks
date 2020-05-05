package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/* 
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: "May is the 5 month".
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        List<String> list = Arrays.stream(Month.values()).map(Enum::toString)
                .collect(Collectors.toList());

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String month = reader.readLine();
        String monthUp = month.toUpperCase();
        System.out.printf("%s is the %d month", month, list.indexOf(monthUp) + 1);

    }
}

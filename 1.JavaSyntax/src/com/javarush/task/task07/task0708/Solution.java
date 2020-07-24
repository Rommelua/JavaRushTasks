package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самая длинная строка
*/

public class Solution {
    private static ArrayList<String> strings;

    public static void main(String[] args) throws Exception {
        strings = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        strings.add(reader.readLine());
        strings.add(reader.readLine());
        strings.add(reader.readLine());
        strings.add(reader.readLine());
        strings.add(reader.readLine());
        int maxLength = strings.stream().mapToInt(String::length).max().getAsInt();
        strings.stream().filter(s -> s.length() == maxLength).forEach(System.out::println);
    }
}

package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> strings = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            strings.add(reader.readLine());
        }
        int maxLength = strings.stream().max(Comparator.comparing(String::length)).get().length();
        int minLength = strings.stream().min(Comparator.comparing(String::length)).get().length();
        String o = strings.stream().filter(s -> s.length() == maxLength || s.length() == minLength)
                .findFirst().get();
        System.out.println(o);
    }
}

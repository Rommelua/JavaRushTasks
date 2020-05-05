package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        string = string.trim();
//        string = Stream.of(string.split("\\s+"))
//                .map(s -> s.replaceFirst(".", s.substring(0, 1).toUpperCase()))
//                .collect(Collectors.joining(" "));
        String[] firstLetters = string.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < firstLetters.length; i++) {
            firstLetters[i] = firstLetters[i]
                    .replaceFirst(".", firstLetters[i].substring(0, 1).toUpperCase());
            result.append(firstLetters[i]).append(" ");
        }
        System.out.println(result.toString());
    }
}
